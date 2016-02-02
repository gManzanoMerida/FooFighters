package com.gmm.fooWebProject.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
 

import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import javax.sql.DataSource;


import oracle.jdbc.pool.OracleDataSource; 

/**
 * Conexión estática
 * @author 0012464
 *
 */
public class OracleConnection{  
	
	private static String oracleUrl = null;//"jdbc:oracle:thin:@//10.252.61.126:1521/ora1";
	private static String oracleUser= null;//"u602";
	private static String oraclePWD = null;//"u602";
	public static Connection connection = null;	
	public static DataSource dataSource = null;
	private static String response;
	
	 
	
//	public OracleConnection(){
//		this. = ;
//		System.out.println("SendAdjustmentsSynchronizer::OracleConnection");
//		oracleUrl = PropertiesReader.get(Constantes.PROP_ORACLE_URL);
//		oracleUser= PropertiesReader.get(Constantes.PROP_ORACLE_USERNAME);
//		oraclePWD = PropertiesReader.get(Constantes.PROP_ORACLE_PWD);
//	}
	
	public static DataSource getDataSource() {
		
		
		
		Properties props = new Properties();
		OracleDataSource oracleDS = null;
		try {
			oracleUrl = PropertiesReader.get(Constantes.PROP_ORACLE_URL);
			oracleUser= PropertiesReader.get(Constantes.PROP_ORACLE_USERNAME);
			oraclePWD = PropertiesReader.get(Constantes.PROP_ORACLE_PWD);
			
			oracleDS = new OracleDataSource();
			oracleDS.setURL(props.getProperty("ORACLE_DB_URL"));
			oracleDS.setUser(props.getProperty("ORACLE_DB_USERNAME"));
			oracleDS.setPassword(props.getProperty("ORACLE_DB_PASSWORD"));
			oracleDS.setDriverType("thin");
			oracleDS.setPortNumber(1521);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oracleDS;
	}
	
	public static Connection getConnection( ){
		if (connection==null) openConnection();
		return connection;
	}

	public static Connection openConnection(){
		
		////////////////////////////////////////////////////////////////////
		System.out.println("SendAdjustmentsSynchronizer::OracleConnection::getConnection");
		oracleUrl = PropertiesReader.get(Constantes.PROP_ORACLE_URL);
		oracleUser= PropertiesReader.get(Constantes.PROP_ORACLE_USERNAME);
		oraclePWD = PropertiesReader.get(Constantes.PROP_ORACLE_PWD);
		////////////////////////////////////////////////////////////////////
		
		try{			
			 Class. forName (Constantes.PROP_ORACLE_DRIVER);
		     connection = DriverManager.getConnection(oracleUrl,oracleUser,oraclePWD);
		     if (connection!=null){
		    	 System.out.println("SendAdjustmentsSynchronizer::OracleConnection::getConnection:OK");
		     } else {
		    	 System.out.println("SendAdjustmentsSynchronizer::OracleConnection:getConnection:KO"); 
		     }
		}
		catch (ClassNotFoundException e) {
			System.out.println("SendAdjustmentsSynchronizer::getConnection::"+ e.getLocalizedMessage());
			System.out.println("SendAdjustmentsSynchronizer::getConnection::"+ e.getLocalizedMessage()); 
	    }
		catch (SQLException sqle) {
			System.out.println("SendAdjustmentsSynchronizer::getConnection::"+ sqle.getLocalizedMessage());
			System.out.println("SendAdjustmentsSynchronizer::getConnection::"+ sqle.getLocalizedMessage()); 
	    }
		return connection;
	}

	public static String closeConnection(Connection connection ) {
		String response = "OK"+Constantes.DELIMITER+"ZERO";
		try{
			if(connection!=null){
				connection.close();
			}
		}
		catch (SQLException sqle) {
			System.out.println("SendAdjustmentsSynchronizer::OracleConnection::"+ sqle.getLocalizedMessage());
			response = "7"+Constantes.DELIMITER+sqle.getLocalizedMessage();
	    }
		return response;
	}
	
	public static boolean hayBatchActivo(Connection connection, String codEmpresa ) throws SQLException {

		boolean batchActivo = true;

		String query = "SELECT XBATCACT FROM T9084300 WHERE CEMPRESA=?";

		String response = "";
		if (connection!=null) {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, codEmpresa);
			System.out.println("SendAdjustmentsSynchronizer::OracleConnection::hayBatchActivo::query=" + query);
			 
			ResultSet rs = ps.executeQuery();

			if (rs != null && !rs.isClosed()) {
				rs.next();
				System.out.println("SendAdjustmentsSynchronizer::OracleConnection::hayBatchActivo::Valor de XBATCACT=" + rs.getInt(Constantes.FLD_XBATCACT)); 
				batchActivo = (rs.getInt(Constantes.FLD_XBATCACT) == Integer .parseInt(Constantes.LITERAL_1));

				rs.close();
			}

			ps.close();

			if (connection != null && !connection.isClosed()){
				response = closeConnection(connection);
				System.out.println("SendAdjustmentsSynchronizer::OracleConnection::hayBatchActivo::closeConnection::" + response);
			}

		}
		return batchActivo;
	}
	
	
	public static void getAllFromTable(Connection connection, String tabla) throws SQLException {

	 

		String query = "SELECT XBATCACT FROM T9084300";

		String response = "";
		if (connection != null) {
			Statement stmt = connection.createStatement();
			ResultSet rs;

			rs = stmt.executeQuery(query);
			while (rs.next()) { 
				System.out.println(rs.getString("XBATCACT"));
			}
			connection.close();

			if (connection != null && !connection.isClosed()) {
				response = closeConnection(connection );
				 
			}

		} 
	}
	
	
	public static void main(String[] args) {
		
		///////////////////////////////////////////////////////////////////
		///GMM:11:18:12::Conexion normal
		OracleConnection.connection =  OracleConnection.getConnection();
		
		try {
			boolean ok = false;
			if (connection!=null){
				
				System.out.println("connection.isValid:" + connection.isValid(0));
				 OracleConnection.getAllFromTable(connection, "01" );
				System.out.println("hayBatchActivo:" + ok);
			} else {
				System.out.println("connection = null");
			}
			
			
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		


		//////////////////////////////////////////////////////////////////
		///GMM:11:18:27::Conexion con datasource--> no funciona con la configuracion ECI-OpenDev
//		DataSource ds =  OracleConnection.getDataSource();
//		
//		
//
//		try {
//			boolean ok = false;
//			Connection connection = ds.getConnection(oracleUser, oraclePWD);
//			if (connection!=null){
//				
//				System.out.println("connection.isValid:" + connection.isValid(0));
//				ok = OracleConnection.hayBatchActivo(connection, "", );
//				System.out.println("hayBatchActivo:" + ok);
//			} else {
//				System.out.println("connection = null");
//			}
//		} catch (SQLException e) {
//			System.out.println(e);
//			e.printStackTrace();
//		}

	}
	

	 

}
