import java.awt.*;

public class Bubble implements XmasShape {
    int x;
    int y;
    double scale;
    Color lineColor;
    Color fillColor;
    private Color bubbleColor;


    Bubble(int a, int b, double s,Color bubColor){
        this.x=a;
        this.y=b;
        this.scale=s;
        this.bubbleColor=bubColor;
    }



    @Override
    public void render(Graphics2D g2d) {
        // ustaw kolor wypełnienia
        g2d.setColor(bubbleColor);
        g2d.fillOval(0,0,20,20);
        // ustaw kolor obramowania
        g2d.drawOval(0,0,20,20);
    }

    @Override
    public void transform(Graphics2D g2d) {
        g2d.translate(x,y);
        g2d.scale(scale,scale);
    }
}