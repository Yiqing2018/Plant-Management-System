/**
 * function:mini版
 * @author liu
 */
package inventory;
import javax.swing.*;
import login.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;
public class Query extends JFrame implements ActionListener{

	JPanel jp1,jp2,jp3;
	JLabel jl1;
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	JTable jt,jt2;
	JScrollPane jsp,jsp2;
	JTextField jtf;
	public static void main(String[] args) {
		// TODO Auto-generated method 
		Query ts=new Query();
     //Login login=new Login();

	}
	
	public Query(){
		jp1=new JPanel();
		jp3=new JPanel();
		jtf=new JTextField(10);
		
		jb1=new JButton("查询");
		jb1.setFont(new Font("微软雅黑",Font.BOLD,15));
		jb1.addActionListener(this);
		jb1.setActionCommand("aa");
		
		jb5=new JButton("刷新");
		jb5.setFont(new Font("微软雅黑",Font.BOLD,15));
		jb5.addActionListener(this);
		jb5.setActionCommand("ee");
		
		jb6=new JButton("返回");
		jb6.setFont(new Font("微软雅黑",Font.BOLD,12));
		jb6.addActionListener(this);
		jb6.setActionCommand("ff");
		
		
		jl1=new JLabel("请输入产品号/零件号");
		jl1.setFont(new Font("微软雅黑",Font.BOLD,13));

		jp1.add(jb6);
		jp1.add(jl1);
		jp1.add(jtf);
		jp1.add(jb1);
		jp1.add(jb5);
		
		jp2=new JPanel();
		
		jb2=new JButton("仓库管理");
		jb2.setFont(new Font("微软雅黑",Font.BOLD,15));

		jb2.addActionListener(this);
		jb2.setActionCommand("bb");
		
		jb3=new JButton("库存更新");
		jb3.setFont(new Font("微软雅黑",Font.BOLD,15));

		jb3.addActionListener(this);
		jb3.setActionCommand("cc");
		
		jb4=new JButton("安全库存");
		jb4.setFont(new Font("微软雅黑",Font.BOLD,15));

		jb4.addActionListener(this);
		jb4.setActionCommand("dd");
		
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
	
		//出现所有可查询的对象 调用构造方法 FacModel()
		FacModel fm=new FacModel();
		jt=new JTable(fm);
		jsp=new JScrollPane(jt);
		
		
		ComModel com=new ComModel();
		jt2=new JTable(com);
		jsp2=new JScrollPane(jt2);
		
		jp3.setLayout(new GridLayout(2,1));
		jp3.add(jsp);
		jp3.add(jsp2);
		
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp3,BorderLayout.CENTER);
		this.add(jp2,BorderLayout.SOUTH);

		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocation(450, 200);
		this.setTitle("欢迎进入库存管理系统");
		this.setIconImage((new ImageIcon( "images\\cangku.png")).getImage());


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//判断被点击的按钮
		if(e.getActionCommand().equals("aa")){
		//接收输入的查询信息！
	
		String name=this.jtf.getText().trim();
		String sql="select Product.Pno,Pname,PInum,Sno from ProductInventory,Product "
				+ "where Product.Pno=ProductInventory.Pno and Product.Pno='"+name+"'";
		
		//如果查询空值 应该出现所有产品/零件目录

		FacModel fm=new FacModel(sql);
		jt.setModel(fm);	
		
		//component!
		String sql2="select Component.COno,COname,CInum,Sno from ComponentInventory,Component "
				+ "where Component.COno=ComponentInventory.COno and Component.COno='"+name+"'";

		//System.out.println(sql2);

		ComModel com=new ComModel(sql2);
		jt2.setModel(com);
		
		}
		
		if(e.getActionCommand().equals("bb")){
			//针对仓库的管理（可查询仓库信息和每个仓库内存的产品）
             //FacAddDialog sad=new FacAddDialog(this,"新产品入库",true);
			StoreHouse sh=new StoreHouse(this,"仓库信息",true);

			
		}
		//更新库存
		if(e.getActionCommand().equals("cc")){
			FacUpdate fu1=new FacUpdate(this,"库存更新",true);

			
		}
		//安全库存
		if(e.getActionCommand().equals("dd")){
			Secure sc=new Secure();
			
		}
		if(e.getActionCommand().equals("ee")){
			String sql="select Product.Pno,Pname,PInum,Sno from ProductInventory,Product "
					+ "where Product.Pno=ProductInventory.Pno";
			String sql2="select Component.COno,COname,CInum,Sno from ComponentInventory,Component "
					+ "where Component.COno=ComponentInventory.COno";
			FacModel fm=new FacModel(sql);
			jt.setModel(fm);
			ComModel com=new ComModel(sql2);
			jt2.setModel(com);
			jtf.setText("");

		}
		
		if(e.getActionCommand().equals("ff")){
			this.dispose();
			Login login2=new Login();
	}

	}
}
