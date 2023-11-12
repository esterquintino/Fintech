package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
	private static final String USUARIO = "rm99592";
	private static final String SENHA = "070786";
	
	
	
	public static Connection abrirConexao() {
		
		
		Connection conexao = null;
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
			
			System.out.println("Conexão feita com sucesso");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Classe não encontrada");
		} catch (SQLException e) {
			System.out.println("Não foi possível conectar");
		}
		
		return conexao;
	
	}
	
	

}
