package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
	private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver" ; 
	private static final String DBURL = "jdbc:mysql://127.0.0.1:3306/webdb?useSSL=false" ;
	private static final String DBUSER = "root" ;
	private static final String DBPASSWORD = "hemysql8888" ;
	private Connection conn ;
	public DBconnection() throws Exception {
		Class.forName(DBDRIVER) ;
		this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD) ;
		//this.conn.createStatement().execute("SET NAMES utf8");
	}
	public Connection getConnection(){
		return this.conn ;
	}
	
	public void close() throws Exception {
		if(this.conn != null){
			try{
				this.conn.close() ;
			}catch(Exception e){
				throw e ;
			}
		}
	}

}
