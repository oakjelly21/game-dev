import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.Random;

public class Dot extends Component{
    public int x;
    public int y;
    public Color c;
    public int x2;
    public int y2;
    public boolean fin;
    Dot(int x, int y, int x2, int y2, Color d,boolean f){
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
        this.c = d;
        this.fin = f;
    }
    public void paint(Graphics g){
        g.setColor(c);
        g.fillRect(this.x, this.y, this.x2, this.x2);
    }
}