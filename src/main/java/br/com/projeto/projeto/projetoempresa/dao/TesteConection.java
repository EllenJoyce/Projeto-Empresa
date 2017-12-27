package br.com.projeto.projeto.projetoempresa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
*
* @author Inmetrics Ellen Joyce
*/

//Classe para teste de conexão com banco de dados

public class TesteConection {
	//private Connection conex;
	
	public static Connection connect() throws InstantiationException {
		String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=PROJETO_EMPRESA";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			Connection 	conex = DriverManager.getConnection(connectionUrl,"sa","Inmetrics_2017");

			System.out.println("Conexão Realizada com Sucesso");
			return conex;
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			return null;
		} catch (Exception e) {
			System.out.println("Erro na conexão");
			return null;
		
		}
		
// Fechando a conexão
}
	}
