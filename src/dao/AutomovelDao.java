package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Automovel;
import model.Viagem;

public class AutomovelDao implements AutomovelDaoIn {
	
	private Connection conexao;
	
	public AutomovelDao(Connection _conexao) {
		this.conexao = _conexao;
	}

	@Override
	public void Insert(Automovel _objeto) throws SQLException {

		String SQL = "INSERT INTO automovel (locadora_idlocadora, modelo, tipo, ano, marca) VALUES (?, ?, ?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getLocadora_idlocadora());
		ps.setString(2, _objeto.getModelo());
		ps.setString(3, _objeto.getTipo());
		ps.setInt(4, _objeto.getAno());
		ps.setString(5, _objeto.getMarca());
		
		ps.execute();

	}

	@Override
	public Boolean Delete(int _id) throws SQLException {
		
		String SQL = "DELETE FROM automovel WHERE idautomovel = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
			
		return ps.execute();
	}

	@Override
	public Boolean Update(Automovel _objeto) throws SQLException {
		
		String SQL = "UPDATE automovel SET locadora_idlocadora = ?, modelo = ?, tipo = ?, ano = ?, marca = ? WHERE idautomovel = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getLocadora_idlocadora());
		ps.setString(2, _objeto.getModelo());
		ps.setString(3, _objeto.getTipo());
		ps.setInt(4, _objeto.getAno());
		ps.setString(5, _objeto.getMarca());
		ps.setInt(6, _objeto.getIdautomovel());
		
		return ps.execute();
	}

	@Override
	public List<Automovel> GetAll() throws SQLException {
		
		List<Automovel> listaAutomovel = new ArrayList<Automovel>();
		
		String SQL = "SELECT idautomovel, locadora_idlocadora, modelo, tipo, ano, marca FROM automovel";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int idautomovel = rs.getInt(1);
			int locadora_idlocadora = rs.getInt(2);
			String modelo = rs.getString(3);
			String tipo = rs.getString(4);
			int ano = rs.getInt(5);
			String marca = rs.getString(6);
			
			ViagemDao daoViagem = new ViagemDao(conexao);
			
			List<Viagem> listaViagensdoAutomovel = daoViagem.GetAllForAutomovel(idautomovel);
			
			listaAutomovel.add(new Automovel(idautomovel, locadora_idlocadora, modelo, tipo, ano, marca, listaViagensdoAutomovel));
		}
				
		return listaAutomovel;
	}

	@Override
	public Automovel GetForID(int _id) throws SQLException {
		
		String SQL = "SELECT idautomovel, locadora_idlocadora, modelo, tipo, ano, marca FROM automovel WHERE idautomovel = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int idautomovel = rs.getInt(1);
			int locadora_idlocadora = rs.getInt(2);
			String modelo = rs.getString(3);
			String tipo = rs.getString(4);
			int ano = rs.getInt(5);
			String marca = rs.getString(6);
			
			ViagemDao daoViagem = new ViagemDao(conexao);
			
			List<Viagem> listaViagensdoAutomovel = daoViagem.GetAllForAutomovel(idautomovel);
			
			Automovel automovel = new Automovel(idautomovel, locadora_idlocadora, modelo, tipo, ano, marca, listaViagensdoAutomovel);
			
			return automovel;
			
		}
		
		return null;
	}

	@Override
	public List<Automovel> GetAllForLocadora(int _idlocadora) throws SQLException {

		List<Automovel> listaAutomovel = new ArrayList<Automovel>();
		
		String SQL = "SELECT idautomovel, locadora_idlocadora, modelo, tipo, ano, marca FROM automovel WHERE locadora_idlocadora = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _idlocadora);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int idautomovel = rs.getInt(1);
			int locadora_idlocadora = rs.getInt(2);
			String modelo = rs.getString(3);
			String tipo = rs.getString(4);
			int ano = rs.getInt(5);
			String marca = rs.getString(6);
			
			ViagemDao daoViagem = new ViagemDao(conexao);
			
			List<Viagem> listaViagensdoAutomovel = daoViagem.GetAllForAutomovel(idautomovel);
			
			listaAutomovel.add(new Automovel(idautomovel, locadora_idlocadora, modelo, tipo, ano, marca, listaViagensdoAutomovel));

		}
		
		
		return listaAutomovel;
	}

}
