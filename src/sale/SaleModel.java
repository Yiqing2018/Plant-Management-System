/**
 * 为了提高代码复用性
 * 对表的数据封装到这
 * 
 */
package sale;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class SaleModel  extends AbstractTableModel{

	Vector rowData,columnNames;
	Connection ct=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public void init(String sql){
		if(sql.equals("")){
			sql="select * from Sale";
		}
		
		columnNames=new Vector();
		columnNames.add("合同号");
		columnNames.add("员工号");
		columnNames.add("经办人");
		columnNames.add("客户号");
		columnNames.add("产品号");
		columnNames.add("数量");
		columnNames.add("单价");
		columnNames.add("日期");
		columnNames.add("交易额");

		
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
				hang.add(rs.getString(6));
				hang.add(rs.getString(7));
				hang.add(rs.getString(8));
				hang.add(rs.getString(9));

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
	
	//冗余代码：2个构造函数——里面的代码重复 改进：
	//通过传递的sql语句来获得数据模型
	public SaleModel(String sql){
		this.init(sql);
	}
	//构造函数 用于初始化我们的数据模型(表)
	public SaleModel(){
		this.init("");
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
