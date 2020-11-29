package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Viagem;

public class ViagemDao implements ViagemDaoIn {
	
	private Connection conexao;
	
	public ViagemDao(Connection _conexao) {
		this.conexao = _conexao;
	}

	@Override
	public void Insert(Viagem _objeto) throws SQLException {
		
		String SQL = "INSERT INTO viagem (cliente_idcliente, motorista_idmotorista, automovel_idautomovel, data, duracao, inicio) VALUES (?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getCliente_idcliente());
		ps.setInt(2, _objeto.getMotorista_idmotorista());
		ps.setInt(3, _objeto.getAutomovel_idautomovel());
		ps.setString(4, _objeto.getData());
		ps.setString(5, _objeto.getDuracao());
		ps.setString(6, _objeto.getInicio());
		
		ps.execute();
	}

	@Override
	public Boolean Delete(int _id) throws SQLException {
		
		String SQL = "DELETE FROM viagem WHERE idviagem = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
			
		return ps.execute();
	}

	@Override
	public Boolean Update(Viagem _objeto) throws SQLException {
		
		String SQL = "UPDATE viagem SET cliente_idcliente = ?, motorista_idmotorista = ?, automovel_idautomovel = ?, data = ?, duracao = ?, inicio = ? WHERE idviagem = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getCliente_idcliente());
		ps.setInt(2, _objeto.getMotorista_idmotorista());
		ps.setInt(3, _objeto.getAutomovel_idautomovel());
		ps.setString(4, _objeto.getData());
		ps.setString(5, _objeto.getDuracao());
		ps.setString(6, _objeto.getInicio());
		ps.setInt(7, _objeto.getIdviagem());
		
		return ps.execute();
	}

	@Override
	public List<Viagem> GetAll() throws SQLException {
		
		List<Viagem> listaViagem = new ArrayList<Viagem>();
		
		String SQL = "SELECT idviagem, cliente_idcliente, motorista_idmotorista, automovel_idautomovel, data, duracao, inicio FROM viagem";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int idviagem = rs.getInt(1);
			int cliente_idcliente = rs.getInt(2);
			int motorista_idmotorista = rs.getInt(3);
			int automovel_idautomovel = rs.getInt(4);
			String data = rs.getString(5);
			String duracao = rs.getString(6);
			String inicio = rs.getString(7);
			
			listaViagem.add(new Viagem(idviagem, cliente_idcliente, motorista_idmotorista, automovel_idautomovel, data, duracao, inicio));
		}
				
		return listaViagem;
	}

	@Override
	public Viagem GetForID(int _id) throws SQLException {
		
		String SQL = "SELECT idviagem, cliente_idcliente, motorista_idmotorista, automovel_idautomovel, data, duracao, inicio FROM viagem WHERE idviagem = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int idviagem = rs.getInt(1);
			int cliente_idcliente = rs.getInt(2);
			int motorista_idmotorista = rs.getInt(3);
			int automovel_idautomovel = rs.getInt(4);
			String data = rs.getString(5);
			String duracao = rs.getString(6);
			String inicio = rs.getString(7);
			
			Viagem viagem = new Viagem(idviagem, cliente_idcliente, motorista_idmotorista, automovel_idautomovel, data, duracao, inicio);
			
			return viagem;
		}
		
		return null;
	}


	@Override
	public List<Viagem> GetAllForCliente(int _idcliente) throws SQLException {

		List<Viagem> listaViagem = new ArrayList<Viagem>();
		
		String SQL = "SELECT idviagem, cliente_idcliente, motorista_idmotorista, automovel_idautomovel, data, duracao, inicio FROM viagem WHERE cliente_idcliente = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _idcliente);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int idviagem = rs.getInt(1);
			int cliente_idcliente = rs.getInt(2);
			int motorista_idmotorista = rs.getInt(3);
			int automovel_idautomovel = rs.getInt(4);
			String data = rs.getString(5);
			String duracao = rs.getString(6);
			String inicio = rs.getString(7);
						
			listaViagem.add(new Viagem(idviagem, cliente_idcliente, motorista_idmotorista, automovel_idautomovel, data, duracao, inicio));
		}
			
		return listaViagem;
	}

	@Override
	public List<Viagem> GetAllForMotorista(int _idmotorista) throws SQLException {
		
		List<Viagem> listaViagem = new ArrayList<Viagem>();
		
		String SQL = "SELECT idviagem, cliente_idcliente, motorista_idmotorista, automovel_idautomovel, data, duracao, inicio FROM viagem WHERE motorista_idmotorista = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _idmotorista);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int idviagem = rs.getInt(1);
			int cliente_idcliente = rs.getInt(2);
			int motorista_idmotorista = rs.getInt(3);
			int automovel_idautomovel = rs.getInt(4);
			String data = rs.getString(5);
			String duracao = rs.getString(6);
			String inicio = rs.getString(7);
						
			listaViagem.add(new Viagem(idviagem, cliente_idcliente, motorista_idmotorista, automovel_idautomovel, data, duracao, inicio));
		}
			
		return listaViagem;
	}

	@Override
	public List<Viagem> GetAllForAutomovel(int _idautomovel) throws SQLException {

		List<Viagem> listaViagem = new ArrayList<Viagem>();
		
		String SQL = "SELECT idviagem, cliente_idcliente, motorista_idmotorista, automovel_idautomovel, data, duracao, inicio FROM viagem WHERE automovel_idautomovel = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _idautomovel);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int idviagem = rs.getInt(1);
			int cliente_idcliente = rs.getInt(2);
			int motorista_idmotorista = rs.getInt(3);
			int automovel_idautomovel = rs.getInt(4);
			String data = rs.getString(5);
			String duracao = rs.getString(6);
			String inicio = rs.getString(7);
						
			listaViagem.add(new Viagem(idviagem, cliente_idcliente, motorista_idmotorista, automovel_idautomovel, data, duracao, inicio));
		}
			
		return listaViagem;
	}

}
