package dao;

import java.sql.*;

public class DAO {
	protected static Connection conexao;
	
	public DAO() {
		conexao = null;
	}

	public boolean conectar() {
		boolean status = (conexao == null);
		if(status)
		{
			String driverName = "org.postgresql.Driver";                    
			String serverName = "localhost";
			String mydatabase = "SM";
			int porta = 5432;
			String url = "jdbc:postgresql://" + serverName + ":" + porta +"/" + mydatabase;
			String username = "ti2cc";
			String password = "ti@cc";
	
			try {
				Class.forName(driverName);
				conexao = DriverManager.getConnection(url, username, password);
				status = (conexao == null);
				System.out.println("Conexão efetuada com o postgres!");
			} catch (ClassNotFoundException e) { 
				System.err.println("Conexão NÃO efetuada com o postgres -- Driver não encontrado -- " + e.getMessage());
			} catch (SQLException e) {
				System.err.println("Conexão NÃO efetuada com o postgres -- " + e.getMessage());
			}
		}

		return status;
	}
	
	public boolean close() {
		boolean status = false;
		
		try {
			conexao.close();
			status = true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return status;
	}
}