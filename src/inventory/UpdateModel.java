package inventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateModel {

	Connection ct=null;
	PreparedStatement ps=null;
	int i=0;
	//str1 产品还是零件 str2 +还是-
	public UpdateModel(int flag,char str2,int ium,String no){
		
		String sql1="UPDATE ProductInventory set "
				+ "PInum=PInum"+str2+ium+" where Pno='"+no+"'";
		String sql2="UPDATE ComponentInventory set "
				+ "CInum=CInum"+str2+ium+" where COno='"+no+"'";
		try{
			//System.out.println("try");
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			ct=DriverManager.getConnection("jdbc:microsoft:sqlserver://127.0.0.1:1433;"
					+ "databaseName=FMS","sa","sa");
		
			if(flag==1){	
				ps=ct.prepareStatement(sql1);
				}else{
					ps=ct.prepareStatement(sql2);
				}
			

			i=ps.executeUpdate();
							
			}
			catch(Exception e1){
				
			}finally{
				try {
					if(ps!=null){
					ps.close();}
				}catch (SQLException e1) {
					e1.printStackTrace();}
				try {
					if(ct!=null){
					ct.close();}
				}catch (SQLException e1) {
					e1.printStackTrace();}
				
			}
		
	}
	public int panduan(){
		return i;
	}
}
