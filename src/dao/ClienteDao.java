package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.Viagem;

public class ClienteDao implements ClienteDaoIn {
	
	private Connection conexao;
	
	public ClienteDao(Connection _conexao) {
		this.conexao = _conexao;
	}

	@Override
	public void Insert(Cliente _objeto) throws SQLException {
		
		String SQL = "INSERT INTO cliente (cpf, cel, nome, endereco, cidade, email) VALUES (?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getCpf());
		ps.setInt(2, _objeto.getCel());
		ps.setString(3, _objeto.getNome());
		ps.setString(4, _objeto.getEndereco());
		ps.setString(5, _objeto.getCidade());
		ps.setString(6, _objeto.getEmail());
		
		ps.execute();

	}

	@Override
	public Boolean Delete(int _id) throws SQLException {
		
		String SQL = "DELETE FROM cliente WHERE idcliente = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
			
		return ps.execute();
	}

	@Override
	public Boolean Update(Cliente _objeto) throws SQLException {
		
		String SQL = "UPDATE cliente SET cpf = ?, cel = ?, nome = ?, endereco = ?, cidade = ?, email = ? WHERE idcliente = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getCpf());
		ps.setInt(2, _objeto.getCel());
		ps.setString(3, _objeto.getNome());
		ps.setString(4, _objeto.getEndereco());
		ps.setString(5, _objeto.getCidade());
		ps.setString(6, _objeto.getEmail());
		ps.setInt(7, _objeto.getIdcliente());
		
		return ps.execute();
	}

	@Override
	public List<Cliente> GetAll() throws SQLException {

		List<Cliente> listaCliente = new ArrayList<Cliente>();
		
		String SQL = "SELECT idcliente, cpf, cel, nome, endereco, cidade, email FROM cliente";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int idcliente = rs.getInt(1);
			int cpf = rs.getInt(2);
			int cel = rs.getInt(3);
			String nome = rs.getString(4);
			String endereco = rs.getString(5);
			String cidade = rs.getString(6);
			String email = rs.getString(7);
			
			ViagemDao daoViagem = new ViagemDao(conexao);
			
			List<Viagem> listaViagensdoCliente = daoViagem.GetAllForCliente(idcliente);
			
			listaCliente.add(new Cliente(idcliente, cpf, cel, nome, endereco, cidade, email, listaViagensdoCliente));
		}
				
		return listaCliente;
	}

	@Override
	public Cliente GetForID(int _id) throws SQLException {
		
		String SQL = "SELECT idcliente, cpf, cel, nome, endereco, cidade, email WHERE idcliente = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int idcliente = rs.getInt(1);
			int cpf = rs.getInt(2);
			int cel = rs.getInt(3);
			String nome = rs.getString(4);
			String endereco = rs.getString(5);
			String cidade = rs.getString(6);
			String email = rs.getString(7);
			
			ViagemDao daoViagem = new ViagemDao(conexao);
			
			List<Viagem> listaViagensdoCliente = daoViagem.GetAllForCliente(idcliente);
			
			Cliente cliente = new Cliente(idcliente, cpf, cel, nome, endereco, cidade, email, listaViagensdoCliente);
			
			return cliente;
			
		}
		
		return null;
	}

}
