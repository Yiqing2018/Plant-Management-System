/**
 * function:mini��
 * @author liu
 */
package inventory;
import javax.swing.*;
import login.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;
public class Query extends JFrame implements ActionListener{

	JPanel jp1,jp2,jp3;
	JLabel jl1;
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	JTable jt,jt2;
	JScrollPane jsp,jsp2;
	JTextField jtf;
	public static void main(String[] args) {
		// TODO Auto-generated method 
		Query ts=new Query();
     //Login login=new Login();

	}
	
	public Query(){
		jp1=new JPanel();
		jp3=new JPanel();
		jtf=new JTextField(10);
		
		jb1=new JButton("��ѯ");
		jb1.setFont(new Font("΢���ź�",Font.BOLD,15));
		jb1.addActionListener(this);
		jb1.setActionCommand("aa");
		
		jb5=new JButton("ˢ��");
		jb5.setFont(new Font("΢���ź�",Font.BOLD,15));
		jb5.addActionListener(this);
		jb5.setActionCommand("ee");
		
		jb6=new JButton("����");
		jb6.setFont(new Font("΢���ź�",Font.BOLD,12));
		jb6.addActionListener(this);
		jb6.setActionCommand("ff");
		
		
		jl1=new JLabel("�������Ʒ��/�����");
		jl1.setFont(new Font("΢���ź�",Font.BOLD,13));

		jp1.add(jb6);
		jp1.add(jl1);
		jp1.add(jtf);
		jp1.add(jb1);
		jp1.add(jb5);
		
		jp2=new JPanel();
		
		jb2=new JButton("�ֿ����");
		jb2.setFont(new Font("΢���ź�",Font.BOLD,15));

		jb2.addActionListener(this);
		jb2.setActionCommand("bb");
		
		jb3=new JButton("������");
		jb3.setFont(new Font("΢���ź�",Font.BOLD,15));

		jb3.addActionListener(this);
		jb3.setActionCommand("cc");
		
		jb4=new JButton("��ȫ���");
		jb4.setFont(new Font("΢���ź�",Font.BOLD,15));

		jb4.addActionListener(this);
		jb4.setActionCommand("dd");
		
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
	
		//�������пɲ�ѯ�Ķ��� ���ù��췽�� FacModel()
		FacModel fm=new FacModel();
		jt=new JTable(fm);
		jsp=new JScrollPane(jt);
		
		
		ComModel com=new ComModel();
		jt2=new JTable(com);
		jsp2=new JScrollPane(jt2);
		
		jp3.setLayout(new GridLayout(2,1));
		jp3.add(jsp);
		jp3.add(jsp2);
		
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp3,BorderLayout.CENTER);
		this.add(jp2,BorderLayout.SOUTH);

		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocation(450, 200);
		this.setTitle("��ӭ���������ϵͳ");
		this.setIconImage((new ImageIcon( "images\\cangku.png")).getImage());


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//�жϱ�����İ�ť
		if(e.getActionCommand().equals("aa")){
		//��������Ĳ�ѯ��Ϣ��
	
		String name=this.jtf.getText().trim();
		String sql="select Product.Pno,Pname,PInum,Sno from ProductInventory,Product "
				+ "where Product.Pno=ProductInventory.Pno and Product.Pno='"+name+"'";
		
		//�����ѯ��ֵ Ӧ�ó������в�Ʒ/���Ŀ¼

		FacModel fm=new FacModel(sql);
		jt.setModel(fm);	
		
		//component!
		String sql2="select Component.COno,COname,CInum,Sno from ComponentInventory,Component "
				+ "where Component.COno=ComponentInventory.COno and Component.COno='"+name+"'";

		//System.out.println(sql2);

		ComModel com=new ComModel(sql2);
		jt2.setModel(com);
		
		}
		
		if(e.getActionCommand().equals("bb")){
			//��Բֿ�Ĺ����ɲ�ѯ�ֿ���Ϣ��ÿ���ֿ��ڴ�Ĳ�Ʒ��
             //FacAddDialog sad=new FacAddDialog(this,"�²�Ʒ���",true);
			StoreHouse sh=new StoreHouse(this,"�ֿ���Ϣ",true);

			
		}
		//���¿��
		if(e.getActionCommand().equals("cc")){
			FacUpdate fu1=new FacUpdate(this,"������",true);

			
		}
		//��ȫ���
		if(e.getActionCommand().equals("dd")){
			Secure sc=new Secure();
			
		}
		if(e.getActionCommand().equals("ee")){
			String sql="select Product.Pno,Pname,PInum,Sno from ProductInventory,Product "
					+ "where Product.Pno=ProductInventory.Pno";
			String sql2="select Component.COno,COname,CInum,Sno from ComponentInventory,Component "
					+ "where Component.COno=ComponentInventory.COno";
			FacModel fm=new FacModel(sql);
			jt.setModel(fm);
			ComModel com=new ComModel(sql2);
			jt2.setModel(com);
			jtf.setText("");

		}
		
		if(e.getActionCommand().equals("ff")){
			this.dispose();
			Login login2=new Login();
	}

	}
}
