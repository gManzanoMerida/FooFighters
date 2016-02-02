package com.gmm.fooWebProject2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.gmm.fooWebProject2.user.User;

import test.Log4jTest;

public class DBConnection {
	
	final static Logger logger = Logger.getLogger(DBConnection.class);

	private static final String JDBC_CONNECTION = "jdbc:mysql://127.0.0.1:3306/pruebas?user=root&password=1111";
	private static final String COM_MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";
	
	public static Connection connection = null;
	 

	public static Connection getConnection() {
		try {
			Class.forName(COM_MYSQL_JDBC_DRIVER);
			if (connection == null){
				connection = DriverManager.getConnection(JDBC_CONNECTION);
			}
			
			if(logger.isDebugEnabled()){
			    logger.debug("Conexión realizada!!");
			}
		} catch (ClassNotFoundException e) {
			logger.error("Error de conexion", e);
			e.printStackTrace();

		} catch (SQLException e) {
			logger.error("Error de conexion", e);
			e.printStackTrace();

		}
		return connection;
	}
	
	public static void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
				
				if(logger.isDebugEnabled()){
				    logger.debug("Conexión cerrada");
				}
			}
		} catch (Exception e) {
			logger.error("Error al cerrar la conexión: "+ e);
		}
	}

	 

}
