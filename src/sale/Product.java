package sale;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

public class Product extends JDialog implements ActionListener {

	JLabel jl,jl2;
	JPanel jp1,jp2;
	JScrollPane jsp;
	JTable jt;
	public Product(){
		jl=new JLabel("产品目录");
		jl.setFont(new Font("微软雅黑",Font.BOLD,15));
		jl2=new JLabel("注：以上为可供销售的产品信息 若需详细库存资料请登录库存管理系统");
		jp1=new JPanel();
		jp2=new JPanel();
		
		ProductModel pm=new ProductModel();
		jt=new JTable(pm);
		jsp=new JScrollPane(jt);
		
		jp1.add(jl);
		jp2.add(jl2);
		this.add(jp1,BorderLayout.NORTH);
		this.add(jsp,BorderLayout.CENTER);
		this.add(jp2,BorderLayout.SOUTH);

		this.setSize(500,400);
		this.setVisible(true);
		this.setLocation(450, 200);
		this.setIconImage((new ImageIcon( "images\\search.png")).getImage());
		this.setTitle("产品目录");


		

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
