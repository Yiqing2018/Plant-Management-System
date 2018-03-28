package sale;
import inventory.FacModel;
import inventory.FacUpdate;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

import login.Login;
public class Sale extends JFrame implements ActionListener{

	JLabel jl1;
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	JTextField jtf;
	JPanel jp1,jp2,jp3;
	JTable jt;
	JScrollPane jsp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Sale sa=new Sale();
	}
	public Sale(){
		jl1=new JLabel("销售记录：");
		jl1.setFont(new Font("微软雅黑",Font.BOLD,15));
		

		jb1=new JButton("查询");
		jb1.setFont(new Font("微软雅黑",Font.BOLD,15));
		jb1.addActionListener(this);
		jb1.setActionCommand("aa");

		jb2=new JButton("刷新");
		jb2.setFont(new Font("微软雅黑",Font.BOLD,15));
		jb2.addActionListener(this);
		jb2.setActionCommand("bb");

		jb3=new JButton("产品目录");
		jb3.setFont(new Font("微软雅黑",Font.BOLD,15));
		jb3.addActionListener(this);
		jb3.setActionCommand("cc");

		jb4=new JButton("销售录入");
		jb4.setFont(new Font("微软雅黑",Font.BOLD,15));
		jb4.addActionListener(this);
		jb4.setActionCommand("dd");

		jb5=new JButton("客户管理");
		jb5.setFont(new Font("微软雅黑",Font.BOLD,15));
		jb5.addActionListener(this);
		jb5.setActionCommand("ee");
		
		jb6=new JButton("返回");
		jb6.setFont(new Font("微软雅黑",Font.BOLD,15));
		jb6.addActionListener(this);
		jb6.setActionCommand("ff");

		jtf=new JTextField(10);
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		SaleModel salemodel=new SaleModel();
		jt=new JTable(salemodel);
		jsp=new JScrollPane(jt);
		jp2.setLayout(new GridLayout(1,1));
		jp2.add(jsp);
		
		jp1.add(jb6);
		jp1.add(jl1);
		jp1.add(jtf);
		jp1.add(jb1);
		jp1.add(jb2);
		
		jp3.add(jb3);
		jp3.add(jb4);
		jp3.add(jb5);
		
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		this.setSize(650,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocation(350, 200);
		this.setTitle("欢迎进入销售管理系统");
		this.setIconImage((new ImageIcon( "images\\xiaoshou.png")).getImage());


	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("aa")){
			String cno=jtf.getText().trim();
			String sql="select * from Sale where CONNno='"+cno+"'";
			SaleModel sam=new SaleModel(sql);
			jt.setModel(sam);
			
		}
		if(e.getActionCommand().equals("bb")){
			SaleModel sam=new SaleModel();
			jt.setModel(sam);
			
		}
		if(e.getActionCommand().equals("cc")){
			Product product=new Product();
		}
		if(e.getActionCommand().equals("dd")){
			//销售数据录入
			Add add=new Add();
		}		
		if(e.getActionCommand().equals("ee")){
			//客户信息
			Client c=new Client();
			
		}
		if(e.getActionCommand().equals("ff")){
			System.out.println("hi");
			this.dispose();
			Login lo=new Login();
			
		}
	}

}
