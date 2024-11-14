package br.com.fiap.jdbc.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection conectar() {
		try {
			DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br", "tm19", "01042007");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
