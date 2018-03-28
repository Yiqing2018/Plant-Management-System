package inventory;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;
/**
 * function:仓库管理系统
 * @author liu
 *
 */
public class StoreHouse extends JDialog implements ActionListener {
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10,jl11,jl12,jl13,jl14,jl15,jl16;
	JTabbedPane jtp;
	JPanel jp1,jp2,jp3,jp4,jp5;
	JTable jt1,jt2,jt3,jt4,jt5,jt6,jt7,jt8,jt9,jt10,jt11,jt12,jt13,jt14,jt15;
	JScrollPane jsp1,jsp2,jsp3,jsp4,jsp5,jsp6,jsp7,jsp8,jsp9,jsp10,jsp11,jsp12,jsp13,jsp14,jsp15;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public StoreHouse(Frame owner,String title,boolean modal){
		jl1=new JLabel("           仓库信息查询");
		jl1.setFont(new Font("楷体",Font.BOLD,20));

		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jp4=new JPanel();
		jp5=new JPanel();


		jtp=new JTabbedPane();
		jtp.add("仓库一", jp1);
		jtp.add("仓库二", jp2);
		jtp.add("仓库三", jp3);
		jtp.add("仓库四", jp4);
		jtp.add("仓库五", jp5);
		
		//定义jp1
		//FacModel fm=new FacModel();
		
		//仓库一 页签1
		jp1.setLayout(new GridLayout(6,1));
		jl2=new JLabel("仓库信息");
		jl3=new JLabel("产品库存");
		jl4=new JLabel("零件库存");
		StoreModel sm=new StoreModel("S1");
		jt1=new JTable(sm);
		jsp1=new JScrollPane(jt1);
		jp1.add(jl2);
		jp1.add(jsp1);
	
		InventoryModel im=new InventoryModel("S1");
		jt2=new JTable(im);
		jsp2=new JScrollPane(jt2);
		jp1.add(jl3);
		jp1.add(jsp2);
		
		CInventoryModel cm1=new CInventoryModel("S1");
		jt11=new JTable(cm1);
		jsp11=new JScrollPane(jt11);
		jp1.add(jl4);
		jp1.add(jsp11);
		
		
		//仓库二 页签2
		jp2.setLayout(new GridLayout(6,1));
		jl5=new JLabel("仓库信息");
		jl6=new JLabel("产品库存");
		jl7=new JLabel("零件库存");
		StoreModel sm2=new StoreModel("S2");
		jt3=new JTable(sm2);
		jsp3=new JScrollPane(jt3);
		jp2.add(jl5);
		jp2.add(jsp3);
	
		InventoryModel im2=new InventoryModel("S2");
		jt4=new JTable(im2);
		jsp4=new JScrollPane(jt4);
		jp2.add(jl6);
		jp2.add(jsp4);
		
		CInventoryModel cm2=new CInventoryModel("S2");
		jt12=new JTable(cm2);
		jsp12=new JScrollPane(jt12);
		jp2.add(jl7);
		jp2.add(jsp12);
		
		//仓库三 页签3
				jp3.setLayout(new GridLayout(6,1));
				jl8=new JLabel("仓库信息");
				jl9=new JLabel("产品库存");
				jl10=new JLabel("零件库存");
				StoreModel sm3=new StoreModel("S3");
				jt5=new JTable(sm3);
				jsp5=new JScrollPane(jt5);
				jp3.add(jl8);
				jp3.add(jsp5);
			
				InventoryModel im3=new InventoryModel("S3");
				jt6=new JTable(im3);
				jsp6=new JScrollPane(jt6);
				jp3.add(jl9);
				jp3.add(jsp6);
				
				CInventoryModel cm3=new CInventoryModel("S3");
				jt13=new JTable(cm3);
				jsp13=new JScrollPane(jt13);
				jp3.add(jl10);
				jp3.add(jsp13);
		//仓库4
				jp4.setLayout(new GridLayout(6,1));
				jl11=new JLabel("仓库信息");
				jl12=new JLabel("产品库存");
				jl13=new JLabel("零件库存");
				StoreModel sm4=new StoreModel("S4");
				jt7=new JTable(sm4);
				jsp7=new JScrollPane(jt7);
				jp4.add(jl11);
				jp4.add(jsp7);
			
				InventoryModel im4=new InventoryModel("S4");
				jt8=new JTable(im4);
				jsp8=new JScrollPane(jt8);
				jp4.add(jl12);
				jp4.add(jsp8);
				
				CInventoryModel cm4=new CInventoryModel("S4");
				jt14=new JTable(cm4);
				jsp14=new JScrollPane(jt14);
				jp4.add(jl13);
				jp4.add(jsp14);
		//仓库5
				jp5.setLayout(new GridLayout(6,1));
				jl14=new JLabel("仓库信息");
				jl15=new JLabel("产品库存");
				jl16=new JLabel("零件库存");
				StoreModel sm5=new StoreModel("S5");
				jt9=new JTable(sm5);
				jsp9=new JScrollPane(jt9);
				jp5.add(jl14);
				jp5.add(jsp9);
			
				InventoryModel im5=new InventoryModel("S5");
				jt10=new JTable(im5);
				jsp10=new JScrollPane(jt10);
				jp5.add(jl15);
				jp5.add(jsp10);
				
				CInventoryModel cm5=new CInventoryModel("S5");
				jt15=new JTable(cm5);
				jsp15=new JScrollPane(jt15);
				jp5.add(jl16);
				jp5.add(jsp15);

		//添加标签（仓库信息查询）和页签（五个仓库）
		this.add(jl1,BorderLayout.NORTH);
		this.add(jtp, BorderLayout.CENTER);
		this.setSize(400,500);
		this.setVisible(true);
		this.setLocation(450, 200);
		this.setIconImage((new ImageIcon( "images\\search.png")).getImage());

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
