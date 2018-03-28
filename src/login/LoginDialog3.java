package login;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.sql.*;

public class LoginDialog3 extends JDialog {

	JLabel jl1,jl2;
	//构造方法
	public LoginDialog3(Frame owner,String title,boolean modal){
		super(owner,title,modal);
		jl1=new JLabel(new ImageIcon("images/caution.png"));// 路径符号用\\或者/
		jl2=new JLabel("  抱歉，账号与密码不匹配！ ");
		jl2.setFont(new Font("黑体",Font.PLAIN,14));
	    this.add(jl1,BorderLayout.WEST);
		this.add(jl2);
	    this.add(jl2,BorderLayout.CENTER);
		this.setSize(280,100);
		this.setLocation(500, 300);
		this.setVisible(true);
		this.setResizable(false);
	}
}
