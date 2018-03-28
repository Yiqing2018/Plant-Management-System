package login;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import sale.Sale;
import inventory.*;

import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JPanel jp1,jp2,jp3,jp4;
    JButton jb1,jb2;
    JTextField jtf;
    JPasswordField jpf;
    JLabel jl1,jl2,jl3,jl4,jl5,jl6;
    public static void main(String[] args){
    	Login login=new Login();
    }

	public Login(){
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jp4=new JPanel();
		jb1=new JButton("确认");
		jb1.setFont(new Font("黑体",Font.BOLD,12));

		jb1.addActionListener(this);
		jb1.setActionCommand("aa");
		
		jb2=new JButton("取消");
		jb2.setFont(new Font("黑体",Font.BOLD,12));

		jb2.addActionListener(this);
		jb2.setActionCommand("bb");
		jtf=new JTextField(15);
		jpf=new JPasswordField(15);
		//jl1=new JLabel("工厂管理系统登录");
		
		jl4=new JLabel(new ImageIcon("images/user.png"));// 路径符号用\\或者/
		jl5=new JLabel(new ImageIcon("images/pass.png"));// 路径符号用\\或者/
		jl6=new JLabel("                                                           "
				+ "      copyright@author:liuyiqing");
		jl6.setFont(new Font("",Font.ITALIC,10));


		jl1=new JLabel("工厂管理系统登录");
		jl1.setFont(new Font("楷体",Font.BOLD,20));

		jl2=new JLabel("账号");
		jl2.setFont(new Font("黑体",Font.PLAIN,16));

		jl3=new JLabel("密码");
		jl3.setFont(new Font("黑体",Font.PLAIN,16));

		jp1.add(jl1);
		
		jp2.add(jl4);
		jp2.add(jl2);
		jp2.add(jtf);
		
		jp3.add(jl5);
		jp3.add(jl3);
		jp3.add(jpf);
		
		jp4.add(jb1);
		jp4.add(jb2);

		//this.add(jp1,BorderLayout.NORTH);
		//this.add(jp3,BorderLayout.SOUTH);
		//this.add(jp2,BorderLayout.CENTER);
		this.setLayout(new GridLayout(5,1));
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		this.add(jl6);

		this.setIconImage((new ImageIcon( "images\\load.png")).getImage());
		this.setSize(350,220);
		this.setLocation(450, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("登录系统");
		this.setAlwaysOnTop(true);


	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("aa")){
			System.out.println("ok");
			
			Connection ct=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			
			String id=this.jtf.getText().trim();
			char[] pass=this.jpf.getPassword();
			String password=new String(pass);
			
			String sql="select dept from Login where id='"+id+"' and password='"+password+"'";
		
			String dept = null;
			//System.out.println(id);
			//System.out.println(password);
			//System.out.println(sql);
			if(id.length()<=0){
				LoginDialog ld=new LoginDialog(this,"提示",true);
			}
			
			else{
				if(password.length()<=0){
					LoginDialog2 ld2=new LoginDialog2(this,"提示",true);
					}
				else{
					try{
					Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
					ct=DriverManager.getConnection("jdbc:microsoft:sqlserver://127.0.0.1:1433;databaseName=FMS","sa","sa");				
					ps=ct.prepareStatement(sql);
					rs=ps.executeQuery();
					while(rs.next()){
						dept=rs.getString(1);
						System.out.println(dept);
						}
				
					if (dept.equals("cangku")) { 
				    	// TODO： 如果数据校验成功 显示主界面 并关闭登录界面 
				    	//System.out.println("登陆成功");
						this.dispose(); 
						Query query=new Query();
						
				    	}else{
				    		if(dept.equals("xiaoshou")){
				    			//System.out.println("进入销售系统");
								this.dispose(); 
				    			Sale sale=new Sale();
				    		}
				    		else{
				    		//账号与密码不匹配
							LoginDialog3 ld3=new LoginDialog3(this,"提示",true);}
				    	}

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
			
			
		}
			
	}

		if(e.getActionCommand().equals("bb")){
			jtf.setText("");
			jpf.setText("");

			
		}
		}
}
	

