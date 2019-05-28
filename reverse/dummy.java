import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.*;
import java.io.*;

public class dummy extends JPanel{
    int x = 300;
    int y = 400;
     MyMouseMoveListener1 m = new MyMouseMoveListener1();
    int mouseX = 0;
    int mouseY = 0;
    static int xDis = 300;
    static int yDis = 400;
    BufferedReader br ;
    public ArrayList<Dot> obs = new ArrayList<Dot>();
    String message;
    public dummy()throws Exception
    {
         br  = new BufferedReader(new FileReader("levels.txt"));
    }
    public static void main(String[] args)throws Exception{
        dummy d = new dummy();
        JFrame mf = new JFrame();
        mf.add(d);
        mf.setBounds(0,0,900,900);
        mf.setVisible(true);
	mf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       
        mf.addMouseMotionListener(d.m);
        d.input();
    }
    void run()throws Exception
    {
        int flag = -1;
        while(flag<0)
        {
            try
            {Thread.sleep(40);}
            catch(Exception e){}
            repaint();
            flag = check();
         }
         if(flag != 0)
         message = "GAME OVER";
         else
         input();
     }
    public void paint(Graphics g){
                
                super.paint(g);
                g.drawString(message,400,100);
                for(Dot d : obs)
                    d.paint(g);
                g.fillOval(x,y,40,40);
    }
    public int check()
    {
       int flag = 0;
       Iterator i = obs.iterator();
       Rectangle r = new Rectangle(x,y,40,40);
       while(i.hasNext()){
          Dot d = (Dot) i.next();
          Rectangle r1 = new Rectangle(d.x,d.y,d.x2,d.y2);
          if(r1.intersects(r))
          return flag;
          flag++;
       }
       return -1;
    }  
    public void input()throws Exception
    {
       message = br.readLine();
       System.out.println("abd");
       obs.add(new Dot(Integer.parseInt(br.readLine()),Integer.parseInt(br.readLine()),Integer.parseInt(br.readLine()),Integer.parseInt(br.readLine()),Color.red,true));
       System.out.println("abcd");
       try{
       while(!(br.readLine().equals("next level")))
       {
           int x1 = Integer.parseInt(br.readLine());
           int y1 = Integer.parseInt(br.readLine());
           int x2 = Integer.parseInt(br.readLine());
           int y2 = Integer.parseInt(br.readLine());
           obs.add(new Dot(x1,y1,x2,y2,Color.black,false));
           System.out.println("abdce");
        }
        }catch(NumberFormatException e){run();}
         run();
    }  
    class MyMouseMoveListener1 extends MouseMotionAdapter{
        public void mouseMoved(MouseEvent m){
            mouseX = m.getX();
            mouseY = m.getY();
            x+=(xDis-mouseX);
            y+=(yDis-mouseY);
            xDis = mouseX;
            yDis = mouseY;
        }
    }
}