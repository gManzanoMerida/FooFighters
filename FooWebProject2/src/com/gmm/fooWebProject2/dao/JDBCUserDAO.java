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

public class JDBCUserDAO implements UserDAO {
	
	final static Logger logger = Logger.getLogger(JDBCUserDAO.class);

	private static final String JDBC_CONNECTION = "jdbc:mysql://127.0.0.1:3306/pruebas?user=root&password=1111";
	private static final String COM_MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";
	Connection connection = null;

	public Connection getConnection() {
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

	@Override
	public void insert(User user) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user (idUser ,name) VALUES (NULL , ?)");
			preparedStatement.setString(1, user.getName());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
			if(logger.isDebugEnabled()){
			    logger.debug("Usuario insertado: "+ user.getName());
			}
		} catch (SQLException e) {
			logger.error("Error al insertar el usuario: ", e);
			e.printStackTrace();
		}

	}

	@Override
	public List<User> select() {
		List<User> persons = new LinkedList<User>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM user");

			User person = null;
			while (resultSet.next()) {
				person = new User();
				person.setId(Integer.parseInt(resultSet.getString("idUser")));
				person.setName(resultSet.getString("name"));

				persons.add(person);
			}
			resultSet.close();
			statement.close();
			
			if(logger.isDebugEnabled()){
			    logger.debug("SELECT * FROM gmm.persons: ");
			    persons.toString();
			}
		} catch (SQLException e) {
			logger.error("Error al ejecutar la query: \"SELECT * FROM user\": \n", e);
			e.printStackTrace();
		}
		System.out.println(persons);
		return persons;
	}

	public void closeConnection() {
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

	@Override
	public boolean exist(User user) {
		boolean ok = false;
		
		String query = "SELECT idUser FROM pruebas.user WHERE name='"+ user.getName()+"' and pass='"+user.getPass()+"'";
		
		try {			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			 
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()){
				ok=true;
			}
//			int id = resultSet.getRow();
//			if (id!=0){
//				ok=true;
//			}
			preparedStatement.close();
			if(logger.isDebugEnabled()){
			    logger.debug(query+": "+ok);
			}
		} catch (SQLException e) {
			logger.error("Error al ejecutar la query: query "+query +": \n"+ e);
			e.printStackTrace();
		}
		return ok;
	}

}
