package dao;

import java.sql.SQLException;
import java.util.List;

import model.Locadora;

public interface LocadoraDaoIn {

	void Insert(Locadora _objeto) throws SQLException;
		
	Boolean Delete(int _id) throws SQLException;
	
	Boolean Update(Locadora _objeto) throws SQLException;
	
	List<Locadora> GetAll() throws SQLException;
	
	Locadora GetForID(int _id) throws SQLException;
}