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
		jb1=new JButton("ȷ��");
		jb1.setFont(new Font("����",Font.BOLD,12));

		jb1.addActionListener(this);
		jb1.setActionCommand("aa");
		
		jb2=new JButton("ȡ��");
		jb2.setFont(new Font("����",Font.BOLD,12));

		jb2.addActionListener(this);
		jb2.setActionCommand("bb");
		jtf=new JTextField(15);
		jpf=new JPasswordField(15);
		//jl1=new JLabel("��������ϵͳ��¼");
		
		jl4=new JLabel(new ImageIcon("images/user.png"));// ·��������\\����/
		jl5=new JLabel(new ImageIcon("images/pass.png"));// ·��������\\����/
		jl6=new JLabel("                                                           "
				+ "      copyright@author:liuyiqing");
		jl6.setFont(new Font("",Font.ITALIC,10));


		jl1=new JLabel("��������ϵͳ��¼");
		jl1.setFont(new Font("����",Font.BOLD,20));

		jl2=new JLabel("�˺�");
		jl2.setFont(new Font("����",Font.PLAIN,16));

		jl3=new JLabel("����");
		jl3.setFont(new Font("����",Font.PLAIN,16));

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
		this.setTitle("��¼ϵͳ");
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
				LoginDialog ld=new LoginDialog(this,"��ʾ",true);
			}
			
			else{
				if(password.length()<=0){
					LoginDialog2 ld2=new LoginDialog2(this,"��ʾ",true);
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
				    	// TODO�� �������У��ɹ� ��ʾ������ ���رյ�¼���� 
				    	//System.out.println("��½�ɹ�");
						this.dispose(); 
						Query query=new Query();
						
				    	}else{
				    		if(dept.equals("xiaoshou")){
				    			//System.out.println("��������ϵͳ");
								this.dispose(); 
				    			Sale sale=new Sale();
				    		}
				    		else{
				    		//�˺������벻ƥ��
							LoginDialog3 ld3=new LoginDialog3(this,"��ʾ",true);}
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
	

