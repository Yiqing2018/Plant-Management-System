package sale;
import java.sql.*;
import java.util.*;
import java.awt.*;

import javax.swing.*;

public class AddModel {
	Connection ct=null;
	PreparedStatement ps=null;
	int i=0;
	public AddModel(String sql){
		try{
		Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
		ct=DriverManager.getConnection("jdbc:microsoft:sqlserver://127.0.0.1:1433;"
					+ "databaseName=FMS","sa","sa");

		ps=ct.prepareStatement(sql);
		i=ps.executeUpdate();

		System.out.println(i);
		}catch(Exception e){	
			
		}finally{
	
				try {
					if(ps!=null){
					ps.close();}
				}catch (SQLException e) {
					e.printStackTrace();}
					try {
						if(ct!=null){
						ct.close();}
					}catch (SQLException e) {
						e.printStackTrace();}
		}
			
		}

		
	public int jieguo(){
		return i;
	}
	}
