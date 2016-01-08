package com.gmm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.gmm.user.User;

public class JDBCUserDAO implements UserDAO {

	private static final String JDBC_CONNECTION = "jdbc:mysql://localhost/gmm?user=root&password=";
	private static final String COM_MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";
	Connection connection = null;

	public Connection getConnection() {
		try {
			Class.forName(COM_MYSQL_JDBC_DRIVER);
			if (connection == null)
				connection = DriverManager.getConnection(JDBC_CONNECTION);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return connection;
	}

	@Override
	public void insert(User user) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO gmm.users (id ,name) VALUES (NULL , ?)");
			preparedStatement.setString(1, user.getName());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<User> select() {
		List<User> persons = new LinkedList<User>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM gmm.persons");

			User person = null;
			while (resultSet.next()) {
				person = new User();
				person.setId(Integer.parseInt(resultSet.getString("id")));
				person.setName(resultSet.getString("name"));

				persons.add(person);
			}
			resultSet.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(persons);
		return persons;
	}

	public void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			// do nothing
		}
	}

	@Override
	public boolean exist(User user) {
		boolean ok = false;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT id gmm.users (id ,name,pass) VALUES (NULL , ?,?)");
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getPass());
			ResultSet resultSet = preparedStatement.executeQuery();
			int id = resultSet.getRow();
			if (id!=0){
				ok=true;
			}
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ok;
	}

}
