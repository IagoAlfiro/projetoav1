package dao;

import java.sql.SQLException;
import java.util.List;

import model.Cliente;

public interface ClienteDaoIn {

	void Insert(Cliente _objeto) throws SQLException;
		
	Boolean Delete(int _id) throws SQLException;
	
	Boolean Update(Cliente _objeto) throws SQLException;
	
	List<Cliente> GetAll() throws SQLException;
	
	Cliente GetForID(int _id) throws SQLException;
}