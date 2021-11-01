package com.medic.jdbc;
import java.sql.*;
public class JdbcConnectivity 
{
	public static void main(String[] args)throws Exception
	{
		String url="";
		String usrname="";
		String paswrd="";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, usrname, paswrd);
	}

}
