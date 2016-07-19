package com.deal.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


/**
 * 
 * @author gabriel
 *
 */
public class Database {
	
	private String host;
	private String user;
	private String password;
	private String port;
	private String dir;
	private Statement stmt;
	private Connection con;
	public Database() {
	 
	}

	public Database(String h, String u, String p, String po, String s) {
		port = po;
		host = h;
		password = p;
		dir = s;
		user = u;
	}
	

	/////////////////////////////////////////////////////////////////////////////////////
	//oracle
	////////////////////////////////
	public boolean conectar() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@" + host + ":" + port + ":" + dir, user, password);
			stmt = con.createStatement();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean desconectar() {
		try {
			con.close();
			return true;
		} catch (Exception SQLException) {
			return false;
		}
	}
	
	public String ejecutarConsulta(String consulta) { 
		try {

			ResultSet rs = stmt.executeQuery(consulta);
			String devolver = "";
			while (rs.next()) {
				for (int i = 1; i <= rs.getFetchSize(); i++) {
					devolver += rs.getString(i) + " ";
				}
				devolver += "\n";
			}
			return devolver;
		} catch (Exception SQLException) {
			System.out.println("Saltó la escepción\n" + SQLException);
		}
		return "error";
	}
	
	////////////////////////////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////////////////////////////////
	//mysql
	/////////////////////////////////////

	@SuppressWarnings("finally")
	public static Connection GetConnection() {
		Connection conexion = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String servidor = "jdbc:mysql://localhost:3306/hibernate";
			String usuarioDB = "root";
			String passwordDB = "hibernate";
			conexion = DriverManager.getConnection(servidor, usuarioDB, passwordDB);
		} catch (ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, ex, "Error1 en la Conexión con la BD " + ex.getMessage(),
					JOptionPane.ERROR_MESSAGE);
			conexion = null;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex, "Error2 en la Conexión con la BD " + ex.getMessage(),
					JOptionPane.ERROR_MESSAGE);
			conexion = null;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex, "Error3 en la Conexión con la BD " + ex.getMessage(),
					JOptionPane.ERROR_MESSAGE);
			conexion = null;
		} finally {
			return conexion;
		}
	}
	

	public static String exeQuery(Connection con, String consulta) { 
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(consulta);
			String devolver = "";
			while (rs.next()) {
				for (int i = 1; i <= rs.getFetchSize(); i++) {
					devolver += rs.getString(i) + " ";
				}
				devolver += "\n";
			}
			return devolver;
		} catch (Exception SQLException) {
			System.out.println("Saltó la escepción\n" + SQLException);
		}
		return "error";
	}


	public static int exeQueryUpdate(Connection con, String query) { 
		try {
			Statement stmt = con.createStatement(); 			 
			return    stmt.executeUpdate(query);
		} catch (Exception SQLException) {
			System.out.println("Saltó la escepción\n" + SQLException);
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Connection miConexion;
		miConexion =  Database.GetConnection();

		if (miConexion != null) {
			String result;
			JOptionPane.showMessageDialog(null, "Conexión Realizada Correctamente");
			
			String insertQuery ="INSERT INTO cliente (idCliente,nombre,apellidos) VALUES (1,'John','Doe') "
					+ " ON DUPLICATE KEY UPDATE idCliente=idCliente+1;";
			int filasAfectadas = exeQueryUpdate(miConexion, insertQuery);		
			JOptionPane.showMessageDialog(null, "Filas afectadas: "+filasAfectadas);
			
			String selectQuery ="SELECT * FROM cliente;";
			result = exeQuery(miConexion, selectQuery);			
			JOptionPane.showMessageDialog(null, result);
		}
	}
}
