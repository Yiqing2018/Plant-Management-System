package inventory;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

public class Secure extends JDialog implements ActionListener  {

	JPanel jp1,jp2,jp3;
	JLabel jl1,jl2;
	JTable jt1,jt2;
	JScrollPane jsp1,jsp2;
	public Secure(){
		jl1=new JLabel("安全库存查询");
		jl1.setFont(new Font("微软雅黑",Font.BOLD,15));

		jl2=new JLabel("注:以上显示的是库存低于安全库存的产品/零件");
		jl2.setFont(new Font("微软雅黑",Font.PLAIN,10));

		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		SecModel sec1=new SecModel(1);
		SecModel sec2=new SecModel(0);

		jt1=new JTable(sec1);
		jt2=new JTable(sec2);
		jsp1=new JScrollPane(jt1);
		jsp2=new JScrollPane(jt2);
		
		jp1.add(jl1);
		jp2.setLayout(new GridLayout(2,1));
		jp2.add(jsp1);
		jp2.add(jsp2);
		jp3.add(jl2);
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);

		
		this.setSize(400,300);
		this.setLocation(450,250);
		this.setVisible(true);
		this.setIconImage((new ImageIcon( "images\\search.png")).getImage());

		

		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
