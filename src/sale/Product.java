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
		jl=new JLabel("��ƷĿ¼");
		jl.setFont(new Font("΢���ź�",Font.BOLD,15));
		jl2=new JLabel("ע������Ϊ�ɹ����۵Ĳ�Ʒ��Ϣ ������ϸ����������¼������ϵͳ");
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
		this.setTitle("��ƷĿ¼");


		

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
