package com.medic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.medic.jdbc.JdbcConnectivity;
import com.medic.model.PatientModel;

public class PatientDao {
		private Connection connection=null;
		public boolean insertData(PatientModel model) throws ClassNotFoundException, SQLException 
		{
			int result=0;
			boolean isStatus=false;
			connection=JdbcConnectivity.connect(); 
			String sql="insert into PatReg values(null,?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setString(1, model.getFname());
			statement.setString(2,model.getAddress());
			statement.setString(3,model.getLname());
			statement.setString(4,model.getMailid());
			statement.setString(5,model.getGender());
			statement.setString(6,model.getPassword());
			statement.setString(7,model.getConfrimpassword());
			statement.setInt(8, model.getAge());
			statement.setInt(9, model.getPhno());
			
			result=statement.executeUpdate();
			
			if( result>0)
			{
				isStatus=true;
			}
			
			
			return isStatus;

		}
		
	}
