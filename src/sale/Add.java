package sale;
import java.awt.event.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.*;
public class Add extends JDialog implements ActionListener{

	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6;
	JPanel jp1,jp2,jp3;
	JButton jb1,jb2;
	public Add(){
		jl1=new JLabel("销售单录入");
		jl1.setFont(new Font("微软雅黑",Font.BOLD,15));
		jl2=new JLabel("合同号:");
		jl2.setFont(new Font("微软雅黑",Font.BOLD,12));

		jl3=new JLabel("员工号:");
		jl3.setFont(new Font("微软雅黑",Font.BOLD,12));

		jl4=new JLabel("客户号:");
		jl4.setFont(new Font("微软雅黑",Font.BOLD,12));

		jl5=new JLabel("产品号:");
		jl5.setFont(new Font("微软雅黑",Font.BOLD,12));

		jl6=new JLabel("  数量: ");
		jl6.setFont(new Font("微软雅黑",Font.BOLD,12));

		jl7=new JLabel("  日期: ");
		jl7.setFont(new Font("微软雅黑",Font.BOLD,12));

		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jb1=new JButton("确认");
		jb1.setFont(new Font("微软雅黑",Font.BOLD,12));
		jb1.addActionListener(this);
		jb1.setActionCommand("aa");
		jb2=new JButton("取消");
		jb2.setFont(new Font("微软雅黑",Font.BOLD,12));
		jb2.addActionListener(this);
		jb2.setActionCommand("bb");


		jtf1=new JTextField(10);
		jtf2=new JTextField(10);
		jtf3=new JTextField(10);
		jtf4=new JTextField(10);
		jtf5=new JTextField(10);
		jtf6=new JTextField(10);
		
		jp1.add(jl1);
		
		//jp2.setLayout(new GridLayout(6,2));
		jp2.add(jl2);
		jp2.add(jtf1);
		jp2.add(jl3);
		jp2.add(jtf2);
		jp2.add(jl4);
		jp2.add(jtf3);	
		jp2.add(jl5);
		jp2.add(jtf4);
		jp2.add(jl6);
		jp2.add(jtf5);
		jp2.add(jl7);
		jp2.add(jtf6);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		
		this.setSize(200,280);
		this.setVisible(true);
		this.setLocation(500, 200);
		this.setIconImage((new ImageIcon( "images\\search.png")).getImage());
		this.setTitle("销售信息录入");
		
		
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("aa")){
			//确定
			String connno=jtf1.getText().trim();
			String wno=jtf2.getText().trim();
			String cno=jtf3.getText().trim();
			String pno=jtf4.getText().trim();
			String sanum1=jtf5.getText().trim();
			//int转String
			int sanum=Integer.parseInt(sanum1);
			
			String ymd1=jtf6.getText().trim();
			//date转String
			
			/*SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date ymd=sdf.parse(ymd1);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}*/
			
			String sql="insert into Sale(CONNno,Wno,Cno,Pno,SAnum,YMD) "
					+ "values('"+connno+"','"+wno+"','"+cno+"','"
					+pno+"',"+sanum+",'"+ymd1+"')";
			
			//String sql2="UPDATE Sale set AR=Ppri*SAnum";
		
			System.out.println(sql);
			//System.out.println(sql2);

			AddModel addmodel=new AddModel(sql);
			//AddModel addmodel2=new AddModel(sql2);

			if(addmodel.jieguo()!=0){
				AddDialog ad=new AddDialog(this,"yeah~",true);
				this.dispose();
			}
		}
		if(e.getActionCommand().equals("bb")){
			jtf1.setText("");
			jtf2.setText("");
			jtf3.setText("");
			jtf4.setText("");
			jtf5.setText("");

		}
		
	}

}
