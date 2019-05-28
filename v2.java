import java.awt.*;
//import java.awt.Image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.imageio.*;
import java.io.*;

class mine extends JPanel implements KeyListener 
{
	int ctr=0;
	Image img;
	Image img2;
	double p = (int)-1* Math.sqrt(325);
	float r=40;
	int n = 0;
	int n2 = 0;
	int x = 400;
	int y = 325;
	int x2 = 200;
	int y2 = 200;
	boolean b=true;
	boolean a = true;
	public mine()throws Exception
	{
		img = ImageIO.read(new File("untitled.png"));
		img2 = ImageIO.read(new File("untitled2.png"));
	}
	private void call()throws Exception
	{
        	while(a)
		{
			
			Thread.sleep(10);
			
			repaint();
			
		}
	}
	public static void main(String[] args) throws Exception
	{
        	
		JFrame frame = new JFrame("Paper toss");
        	mine game = new mine();
        	frame.add(game);
     		frame.setSize(800, 400);
        	frame.setVisible(true);
        	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(game);
		game.call();
		
	}

	public void paint(Graphics g)
	{
		super.paint(g);	
		
		if(b)
		{
			g.drawImage(img,100,100,null);
			if((x2<400)&(y2==200))
			{n=1;n2=1;}
			if((x2>400)&(y2==200))
			{n=2;n2=-1;}
			if(x2==400)
			n=3;
			if(n==1)
			g.drawLine(x,y,++x2,--y2);
			if(n==2)
			g.drawLine(x,y,--x2,--y2);
			if((n==3)&(n2==1))
			g.drawLine(x,y,++x2,++y2);
			if((n==3)&(n2==-1))
			g.drawLine(x,y,--x2,++y2);
			g.fillOval(x, y, (int)r,(int)r);
		}
		else
		{
			if(!((p*p)>400))
			{
				r-=0.1;
				float m = (y2-325)/(x2-400);
				y--;
				if(!(x==110))
				{
					g.drawImage(img,100,100,null);
					for(int i = 1;i<=800;i++)
					{
						
							if((y-325)==(int)(m*(i-400)))
							{
								x=i;
								g.fillOval(x,(int)(p*p),(int)r,(int)r);
								p+=Math.abs((m/10));
							}
					
					
					}
				}
				else
				{
					
						g.drawString("congratulations",400,100);
						g.drawImage(img2,100,100,null);
						a=false;
						
						
				}
			}
			else
			{
				g.drawString("you failed",400,100);
				a=false;
			}
			
			
		}

		
				
		

	}
	
	public void keyPressed(KeyEvent e)
	{
		/*
		if (e.getKeyCode()==KeyEvent.VK_LEFT)
		x++;
		if (e.getKeyCode()==KeyEvent.VK_RIGHT)
		x--;
		if (e.getKeyCode()==KeyEvent.VK_UP)
		y--;
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
		y++;*/
		if (e.getKeyCode()==KeyEvent.VK_SPACE)
		b=false;
		repaint();

		
	}
	public void keyReleased(KeyEvent e)
	{}
	public void keyTyped(KeyEvent e)
	{}

}
	