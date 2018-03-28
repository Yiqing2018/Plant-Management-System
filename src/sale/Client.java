package sale;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Client extends JDialog implements ActionListener {

	JLabel jl,jl2;
	JPanel jp1,jp2;
	JScrollPane jsp;
	JTable jt;
	public Client(){
		jl=new JLabel("客户信息");
		jl.setFont(new Font("微软雅黑",Font.BOLD,15));
		jl2=new JLabel("注：重要信息，请勿外泄！");
		jp1=new JPanel();
		jp2=new JPanel();
		
		ClientModel cm=new ClientModel();
		jt=new JTable(cm);
		jsp=new JScrollPane(jt);
		
		jp1.add(jl);
		jp2.add(jl2);
		this.add(jp1,BorderLayout.NORTH);
		this.add(jsp,BorderLayout.CENTER);
		this.add(jp2,BorderLayout.SOUTH);

		this.setSize(500,400);
		this.setVisible(true);
		this.setLocation(450, 200);
		this.setIconImage((new ImageIcon( "images\\kehu.png")).getImage());
		this.setTitle("客户信息");

		

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
