package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Motorista;
import model.Viagem;

public class MotoristaDao implements MotoristaDaoIn {

	private Connection conexao;
	
	public MotoristaDao(Connection _conexao) {
		this.conexao = _conexao;
	}

	@Override
	public void Insert(Motorista _objeto) throws SQLException {
		
		String SQL = "INSERT INTO motorista (cpf, idade, cel, email, cidade, nome) VALUES (?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getCpf());
		ps.setInt(2, _objeto.getIdade());
		ps.setInt(3, _objeto.getCel());
		ps.setString(4, _objeto.getEmail());
		ps.setString(5, _objeto.getCidade());
		ps.setString(6, _objeto.getNome());
		
		ps.execute();
	}

	@Override
	public Boolean Delete(int _id) throws SQLException {
		
		String SQL = "DELETE FROM motorista WHERE idmotorista = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
			
		return ps.execute();
	}

	@Override
	public Boolean Update(Motorista _objeto) throws SQLException {
		
		String SQL = "UPDATE motorista SET cpf = ?, idade = ?, cel = ?, email =?, cidade = ?, nome = ? WHERE idmotorista = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getCpf());
		ps.setInt(2, _objeto.getIdade());
		ps.setInt(3, _objeto.getCel());
		ps.setString(4, _objeto.getEmail());
		ps.setString(5, _objeto.getCidade());
		ps.setString(6, _objeto.getNome());
		ps.setInt(7, _objeto.getIdmotorista());
		
		return ps.execute();
	}

	@Override
	public List<Motorista> GetAll() throws SQLException {
		
		List<Motorista> listaMotorista = new ArrayList<Motorista>();
		
		String SQL = "SELECT idmotorista, cpf, idade, cel, email, cidade, nome FROM motorista";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int idmotorista = rs.getInt(1);
			int cpf = rs.getInt(2);
			int idade = rs.getInt(3);
			int cel = rs.getInt(4);
			String email = rs.getString(5);
			String cidade = rs.getString(6);
			String nome = rs.getString(7);
			
			ViagemDao daoViagem = new ViagemDao(conexao);
			
			List<Viagem> listaViagemDoMotorista = daoViagem.GetAllForMotorista(idmotorista);
						
			listaMotorista.add(new Motorista(idmotorista, cpf, idade, cel, email, cidade, nome, listaViagemDoMotorista));
		}
				
		return listaMotorista;
	}

	@Override
	public Motorista GetForID(int _id) throws SQLException {
		
		String SQL = "SELECT idmotorista, cpf, idade, cel, email, cidade, nome FROM motorista WHERE idmotorista = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int idmotorista = rs.getInt(1);
			int cpf = rs.getInt(2);
			int idade = rs.getInt(3);
			int cel = rs.getInt(4);
			String email = rs.getString(5);
			String cidade = rs.getString(6);
			String nome = rs.getString(7);
			
			ViagemDao daoViagem = new ViagemDao(conexao);
			
			List<Viagem> listaViagemDoMotorista = daoViagem.GetAllForMotorista(idmotorista);
			
			Motorista motorista = new Motorista(idmotorista, cpf, idade, cel, email, cidade, nome, listaViagemDoMotorista);
			
			return motorista;
		}
		
		return null;
	}

}
