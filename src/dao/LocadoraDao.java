package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Automovel;
import model.Locadora;

public class LocadoraDao implements LocadoraDaoIn {
	
	private Connection conexao;
	
	public LocadoraDao(Connection _conexao) {
		this.conexao = _conexao;
	}

	@Override
	public void Insert(Locadora _objeto) throws SQLException {
		
		String SQL = "INSERT INTO locadora (endereco, nome, cidade) VALUES (?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getEndereco());
		ps.setString(2, _objeto.getNome());
		ps.setString(3, _objeto.getCidade());
		
		ps.execute();
	}

	@Override
	public Boolean Delete(int _id) throws SQLException {
		
		String SQL = "DELETE FROM locadora WHERE idlocadora = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
			
		return ps.execute();
	}

	@Override
	public Boolean Update(Locadora _objeto) throws SQLException {
		
		String SQL = "UPDATE locadora SET endereco = ?, nome = ?, cidade = ? WHERE idlocadora = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getEndereco());
		ps.setString(2, _objeto.getNome());
		ps.setString(3, _objeto.getCidade());
		ps.setInt(4, _objeto.getIdlocadora());
		
		return ps.execute();
	}

	@Override
	public List<Locadora> GetAll() throws SQLException {
		
		List<Locadora> listaLocadora = new ArrayList<Locadora>();
		
		String SQL = "SELECT idlocadora, endereco, nome, cidade FROM locadora";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int idlocadora = rs.getInt(1);
			String endereco = rs.getString(2);
			String nome = rs.getString(3);
			String cidade = rs.getString(4);
			
			AutomovelDao daoAutomovel = new AutomovelDao(conexao);
			
			List<Automovel> listaAutomovelDaLocadora = daoAutomovel.GetAllForLocadora(idlocadora);
						
			listaLocadora.add(new Locadora(idlocadora, endereco, nome, cidade, listaAutomovelDaLocadora));
		}
				
		return listaLocadora;
	}

	@Override
	public Locadora GetForID(int _id) throws SQLException {
		
		String SQL = "SELECT idlocadora, endereco, nome, cidade FROM locadora WHERE idlocadora = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int idlocadora = rs.getInt(1);
			String endereco = rs.getString(5);
			String nome = rs.getString(6);
			String cidade = rs.getString(7);
			
			AutomovelDao daoAutomovel = new AutomovelDao(conexao);
			
			List<Automovel> listaAutomovelDaLocadora = daoAutomovel.GetAllForLocadora(idlocadora);
			
			Locadora locadora = new Locadora(idlocadora, endereco, nome, cidade, listaAutomovelDaLocadora);
			
			return locadora;
		}
		
		return null;
	}

}
