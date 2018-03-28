package sale;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.sql.*;

public class AddDialog extends JDialog {

	JLabel jl2;
	//构造方法
	public AddDialog(Dialog owner,String title,boolean modal){
		super(owner,title,modal);
		jl2=new JLabel("       成功！ ");
		jl2.setFont(new Font("黑体",Font.PLAIN,15));
		this.add(jl2);
		this.setSize(200,100);
		this.setLocation(480, 250);
		this.setVisible(true);
		this.setResizable(false);
	}
}
