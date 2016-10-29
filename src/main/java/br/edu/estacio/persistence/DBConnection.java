package br.edu.estacio.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection Connect() throws SQLException{
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/pessoas","postgres","postgres");
	}	
	
}
