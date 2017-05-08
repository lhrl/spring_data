package com.lhrl.util;

import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 数据库工具类
 * @author Administrator
 *
 */
public class JDBCUtil {
	
	public static Connection getConnection() throws Exception{
		/*String driveName="com.mysql.jdbc.Driver";
		String url="jdbc:mysql:///spring_data";
		String user="root";
		String password="dmisok";*/
		InputStream inputstream=JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
		Properties properties=new Properties();
		properties.load(inputstream);
		String driverName=properties.getProperty("db.driverName");
		String url=properties.getProperty("db.url");
		String user=properties.getProperty("db.user");
		String password=properties.getProperty("db.password");
		Class.forName(driverName);
		Connection connection=DriverManager.getConnection(url, user, password);
		return connection;
	}
	
	public static void freed(ResultSet rs,Statement statement,Connection connection){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(statement!=null){
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(connection!=null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
