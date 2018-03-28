package inventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class SecModel  extends AbstractTableModel{

	Vector rowData,columnNames;
	Connection ct=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String sql=null;
	public SecModel(int flag){
		if(flag==1){
		sql="select Product.Pno,Pname,PInum,PIss,Sno from ProductInventory,Product "
					+ "where PInum<PIss and Product.Pno=ProductInventory.Pno";
	
		//System.out.println(sql);
		columnNames=new Vector();
		columnNames.add("产品号");
		columnNames.add("产品名称");
		columnNames.add("库存量");
		columnNames.add("安全库存");
		columnNames.add("仓库号");}else{
		sql="select Component.COno,COname,CInum,CIss,Sno from ComponentInventory,Component "
					+ "where CInum<CIss and Component.COno=ComponentInventory.COno";
	
		//System.out.println(sql);
		columnNames=new Vector();
		columnNames.add("零件号");
		columnNames.add("零件名称");
		columnNames.add("库存量");
		columnNames.add("安全库存");
		columnNames.add("仓库号");
		}
		

		
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
				hang.add(rs.getString(4));
				hang.add(rs.getString(5));
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
		// this指jscrollpanel
		return (String)this.columnNames.get(arg0);
	}


	//override三个方法:得到共有多少列
	public int getColumnCount() {
		return this.columnNames.size(); 
	}

	//得到共有多少行
	public int getRowCount() {
		return this.rowData.size();
	}
   //得到某行某列的数据
	public Object getValueAt(int row, int column) {
		return ((Vector) this.rowData.get(row)).get(column);
	}

}
