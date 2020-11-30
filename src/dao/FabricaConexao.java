package dao;

import java.awt.print.Printable;
import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {

	private Connection conexao;
	
	public Connection fazerConexao() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
					
			this.conexao = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/projetoav1",//URL BD com Schema
					"root",//User
					"9b3f351be2"//Password
					);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return this.conexao;
	}
	
	public void fecharConexao() {
		
	}
	
}