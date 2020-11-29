package dao;

import java.sql.SQLException;
import java.util.List;

import model.Motorista;

public interface MotoristaDaoIn {

	void Insert(Motorista _objeto) throws SQLException;
		
	Boolean Delete(int _id) throws SQLException;
	
	Boolean Update(Motorista _objeto) throws SQLException;
	
	List<Motorista> GetAll() throws SQLException;
	
	Motorista GetForID(int _id) throws SQLException;
}