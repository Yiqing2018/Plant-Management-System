
package login;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Index extends JWindow implements Runnable{
	paint p;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Index index=new Index();
		//启动线程
		Thread t=new Thread(index);
		t.start();
	}
	public  Index(){
		//paint implements runnable
		p=new paint();
		this.add(p);
		
		this.setSize(400,250);
		//location
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width/2-200, height/2-150);
		this.setVisible(true);
		this.setAlwaysOnTop(true);

	}
	
	public void run() {
		boolean flag=true;
		int m=0;
		while(flag){
			//waiting 闪屏效果结束后 再跳转到用户登录界面
			try {
				Thread.sleep(22*500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//go to the login
			 Login login=new Login();
			 flag=false;
		}
		this.dispose();
	}

}
class paint extends JPanel implements Runnable{

	Thread t;
	int x=10;
	int i=0,j=40,u=10;
	//String gg[]={"系","统","正","在","加","载","请","稍","候"};
	int k=0,tt=0;
	Font f=new Font("隶书",Font.PLAIN,18);
	boolean ifok=true;
	int width=180;
	int height=0;
	int dian=0;
	
	paint(){
		t=new Thread(this);
		t.start();
	}
	
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			if(x<=380)
				repaint();
			try {
				Thread.sleep(70);//隔一段时间 进度条移动 出现一个字
				i++;
				j=j-6;
				u=u+10;
				if(tt==3)
					width=width-20;
				if(i==4){
					tt++;
					if(ifok&&x>120+k*20)
						k++;
					if(k>=8)
						ifok=false;
					x=x+10;
					i=0;
					j=40;
					u=10;
					dian++;
					if(dian>3)
						dian=0;
					
				}
				
				
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("线程中断");

			}
				
		}
	}
	public void paintComponent(Graphics g){
		//super.paintComponent(g);
		Image image;
		image=Toolkit.getDefaultToolkit().getImage("images\\factory.png");
		g.drawImage(image, 0, 0, this.getWidth(),200,this);		
		g.setColor(new Color(253,250,250));
		g.fillRect(x,210,390-x,30);
		g.setColor(new Color(253,250,250));
		if(i>1)g.fillRect(x,225-(j+20)/2,10,j+20);
		if(j>25)
			g.setColor(new Color(253,250,250));

		else g.setColor(new Color(123,194,252));	
		g.fillRect(x, 225-j/2, 10, j);
		g.setColor(new Color(123,194,252));
		g.drawRect(10,210,380,30);
		
		if(x<120){
			for(int l=0;l<9;l++){
				g.setColor(new Color(0,0,0));
			}
			for(int l=0;l<dian;l++){
				g.setColor(new Color(0,0,0));
			}

			}
		else{
			g.setColor(new Color(23,23,230));
			for(int l=k+1;l<9;l++){
				g.setColor(new Color(0,0,0));
			}
			if(x>300+dian*10)
				g.setColor(new Color(23,23,230));
			for(int l=0;l<dian;l++){
			}

		}

		}
		
	}
	
	

