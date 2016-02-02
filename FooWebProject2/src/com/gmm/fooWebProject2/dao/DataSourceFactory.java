package com.gmm.fooWebProject2.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


public class DataSourceFactory {

	public static DataSource getDataSource() {
		Properties props = new Properties();
		FileInputStream fis = null;
		MysqlDataSource mysqlDS = null;
		try {
			fis = new FileInputStream("src/db.properties");
			props.load(fis);
			mysqlDS = new MysqlDataSource();
			mysqlDS.setURL(props.getProperty("MYSQL_DB_URL"));
			mysqlDS.setUser(props.getProperty("MYSQL_DB_USERNAME"));
			mysqlDS.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mysqlDS;
	}

	public static DataSource getOracleDataSource() {
		Properties props = new Properties();
		FileInputStream fis = null;
		OracleDataSource oracleDS = null;
		try {
			fis = new FileInputStream("src/db.properties");
			props.load(fis);
			oracleDS = new OracleDataSource();
			oracleDS.setURL(props.getProperty("ORACLE_DB_URL"));
			oracleDS.setUser(props.getProperty("ORACLE_DB_USERNAME"));
			oracleDS.setPassword(props.getProperty("ORACLE_DB_PASSWORD"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oracleDS;
	}

	public static void main(String[] args) {

//		testDataSource("mysql");
//		System.out.println("**********");
		 testDataSource("oracle");

	}

	private static void testDataSource(String dbType) {
		DataSource ds = null;
		if ("mysql".equals(dbType)) {
			ds = DataSourceFactory.getDataSource();
		}else if("oracle".equals(dbType)){
			 ds = DataSourceFactory.getOracleDataSource();
		} else {
			System.out.println("invalid db type");
			return;
		}

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM user");
			while (rs.next()) {
				System.out.println("User name:" + rs.getString("name") + ", Last_Name=" + rs.getString("last_name") + ", Pass=" + rs.getString("pass") + ", Email=" + rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
