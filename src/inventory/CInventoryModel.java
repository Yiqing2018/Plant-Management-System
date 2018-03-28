package inventory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class CInventoryModel extends AbstractTableModel{
	Vector rowData,columnNames;
	PreparedStatement ps=null;
	ResultSet rs=null;
	Connection ct=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	CInventoryModel(String Sno){
		String sql="select Component.COno,COname,CInum from ComponentInventory,Component where "
				+ "Component.COno=ComponentInventory.COno and Sno='"+Sno+"'";
		//System.out.println(sql);
		columnNames=new Vector();
		//columnNames.add("²Ö¿âºÅ");
		columnNames.add("Áã¼þ±àºÅ");
		columnNames.add("Áã¼þÃû³Æ");
		columnNames.add("¿â´æ");
		
		rowData=new Vector();
		try{
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			ct=DriverManager.getConnection("jdbc:microsoft:sqlserver://127.0.0.1:1433;databaseName=FMS","sa","sa");
			ps=ct.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Vector hang=new Vector();
				hang.add(rs.getString(1));
				hang.add(rs.getString(2));
				hang.add(rs.getString(3));
				//hang.add(rs.getString(4));
				//hang.add(rs.getString(5));
				rowData.add(hang);

				
			}
		}catch(Exception e){
			
		}finally{
			try {
				if(rs!=null){
				rs.close();}
			}catch (SQLException e) {
				e.printStackTrace();}
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
	
	@Override
	public String getColumnName(int arg0) {
		// thisÖ¸jscrollpanel
		return (String)this.columnNames.get(arg0);
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnNames.size(); 
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rowData.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		return ((Vector) this.rowData.get(row)).get(column);
	}

}
