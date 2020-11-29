package dao;

import java.sql.SQLException;
import java.util.List;

import model.Automovel;

public interface AutomovelDaoIn {

	void Insert(Automovel _objeto) throws SQLException;
		
	Boolean Delete(int _id) throws SQLException;
	
	Boolean Update(Automovel _objeto) throws SQLException;
	
	List<Automovel> GetAll() throws SQLException;
	
	Automovel GetForID(int _id) throws SQLException;
	
	List<Automovel> GetAllForLocadora(int _idlocadora) throws SQLException;
}