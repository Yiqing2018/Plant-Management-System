package inventory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.sql.*;

public class UpdateDialog extends JDialog {

	JLabel jl2;
	//���췽��
	public UpdateDialog(Dialog owner,String title,boolean modal){
		super(owner,title,modal);
		jl2=new JLabel("       ���³ɹ��� ");
		jl2.setFont(new Font("����",Font.PLAIN,15));
		this.add(jl2);
		this.setSize(200,100);
		this.setLocation(480, 250);
		this.setVisible(true);
		this.setResizable(false);
	}
}
