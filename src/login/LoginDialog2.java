package login;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.sql.*;

public class LoginDialog2 extends JDialog {

	JLabel jl1,jl2;	//���췽��
	public LoginDialog2(Frame owner,String title,boolean modal){
		super(owner,title,modal);
		jl1=new JLabel(new ImageIcon("images/caution.png"));// ·��������\\����/
		jl2=new JLabel("   ���������룡 ");
		jl2.setFont(new Font("����",Font.PLAIN,12));

	    this.add(jl1,BorderLayout.WEST);
		this.add(jl2);
	    this.add(jl2,BorderLayout.CENTER);
		this.setSize(200,100);
		this.setLocation(480, 250);
		this.setVisible(true);
		this.setResizable(false);
	}
}
