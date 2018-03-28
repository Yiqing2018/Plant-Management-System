/**
 * Ϊ����ߴ��븴����
 * �Ա������ݷ�װ����
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
		columnNames.add("��ͬ��");
		columnNames.add("Ա����");
		columnNames.add("������");
		columnNames.add("�ͻ���");
		columnNames.add("��Ʒ��");
		columnNames.add("����");
		columnNames.add("����");
		columnNames.add("����");
		columnNames.add("���׶�");

		
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
	
	//������룺2�����캯����������Ĵ����ظ� �Ľ���
	//ͨ�����ݵ�sql������������ģ��
	public SaleModel(String sql){
		this.init(sql);
	}
	//���캯�� ���ڳ�ʼ�����ǵ�����ģ��(��)
	public SaleModel(){
		this.init("");
	}

	@Override
	public String getColumnName(int arg0) {
		// thisָjscrollpanel
		return (String)this.columnNames.get(arg0);
	}


	//override��������:�õ����ж�����
	public int getColumnCount() {
		return this.columnNames.size(); 
	}

	//�õ����ж�����
	public int getRowCount() {
		return this.rowData.size();
	}
   //�õ�ĳ��ĳ�е�����
	public Object getValueAt(int row, int column) {
		return ((Vector) this.rowData.get(row)).get(column);
	}

}