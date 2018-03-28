package inventory;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;
public class FacUpdate extends JDialog implements ActionListener {

	JLabel jl1,jl2,jl3;
	JButton jb1,jb2;
	JTextField jtf1,jtf2;
	JPanel jp1,jp2,jp3,jp4;
	boolean bo;
	String str1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	public FacUpdate(Frame owner,String title,boolean modal){
		super(owner,title,modal);

		jl1=new JLabel("²úÆ·/Áã¼þ¿â´æ¸üÐÂ");
		jl1.setFont(new Font("Î¢ÈíÑÅºÚ",Font.BOLD,18));

		jl2=new JLabel("²úÆ·/Áã¼þºÅ: ");
		jl2.setFont(new Font("Î¢ÈíÑÅºÚ",Font.BOLD,15));

		jl3=new JLabel("ÊýÁ¿: ");
		jl3.setFont(new Font("Î¢ÈíÑÅºÚ",Font.BOLD,15));

		jtf1=new JTextField(10);
		jtf2=new JTextField(10);
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jp4=new JPanel();

		
		jb1=new JButton("Èë¿â");
		jb1.setFont(new Font("Î¢ÈíÑÅºÚ",Font.BOLD,15));
		jb1.addActionListener(this);
		jb1.setActionCommand("aa");
		
		jb2=new JButton("³ö¿â");
		jb2.setFont(new Font("Î¢ÈíÑÅºÚ",Font.BOLD,15));
		jb2.addActionListener(this);
		jb2.setActionCommand("bb");
		
	
		jp1.add(jl1);
		jp2.add(jl2);
		jp2.add(jtf1);
		jp3.add(jl3);
		jp3.add(jtf2);
		jp4.add(jb1);
		jp4.add(jb2);
		this.setLayout(new GridLayout(4,1));
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		
		
		this.setSize(250,200);
		this.setLocation(450,250);
		this.setVisible(true);

	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		str1="P";
		String no=this.jtf1.getText().trim();
		String ium1=this.jtf2.getText().trim();
		int ium=Integer.parseInt(ium1);
		int flag=0;
		char fuhao = 0;

			if(e.getActionCommand().equals("aa")){
				if(no.contains(str1)){	
					flag=1;
					}else{
						flag=0;
					}
				fuhao='+';
				
			}
			
			if(e.getActionCommand().equals("bb")){
				if(no.contains(str1)){	
					flag=1;
					}else{
						flag=0;
					}
				fuhao='-';

			}
			UpdateModel um=new UpdateModel(flag,fuhao,ium,no);
			if(um.panduan()==1){
			UpdateDialog ud=new UpdateDialog(this,"ÌáÊ¾",true);
			 this.dispose();
			 }

		}



	}


