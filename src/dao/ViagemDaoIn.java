package dao;

import java.sql.SQLException;
import java.util.List;

import model.Viagem;

public interface ViagemDaoIn {

	void Insert(Viagem _objeto) throws SQLException;
		
	Boolean Delete(int _id) throws SQLException;
	
	Boolean Update(Viagem _objeto) throws SQLException;
	
	List<Viagem> GetAll() throws SQLException;
	
	Viagem GetForID(int _id) throws SQLException;
	
	List<Viagem> GetAllForCliente(int _idcliente) throws SQLException;

	List<Viagem> GetAllForMotorista(int _idmotorista) throws SQLException;
	
	List<Viagem> GetAllForAutomovel(int _idautomovel) throws SQLException;
	
}