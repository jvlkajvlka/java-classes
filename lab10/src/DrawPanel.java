import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.awt.BasicStroke.CAP_ROUND;
import static java.awt.BasicStroke.JOIN_MITER;

public class DrawPanel extends JPanel {

    private List<XmasShape> shapes = new ArrayList<>();

    Random generator = new Random();

    DrawPanel(){
        setBackground(new Color(0,0,182));
        setOpaque(true);
        Tree tree = new Tree();
        shapes.addAll(tree.treeShapes);

        for (int i = 0; i < 250; i++) {
            Snow s = new Snow(generator.nextInt(1000), generator.nextInt(700), 0.2, new Color(255, 255, 255));
            shapes.add(s);
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(XmasShape s:shapes){
            s.draw((Graphics2D)g);
         }
        drawSnowman(g);
        drawBackground(g);
        drawXmasString(g);



    }

    public void drawSnowman(Graphics g){

        final int MID = 150;
        final int TOP = 320;

        g.setColor (Color.white);
        g.fillOval (MID-20, TOP, 40, 40);
        g.fillOval (MID-35, TOP+35, 70, 50);
        g.fillOval (MID-50, TOP+80, 100, 60);

        g.setColor (Color.black);
        g.fillOval (MID-10, TOP+10, 5, 5);
        g.fillOval (MID+5, TOP+10, 5, 5);

        g.drawArc (MID-10, TOP+20, 20, 10, 190, 160);

        g.drawLine (MID-25, TOP+60, MID-50, TOP+40);
        g.drawLine (MID+25, TOP+60, MID+55, TOP+60);

        g.drawLine (MID-20, TOP+5, MID+20, TOP+5);
        g.fillRect (MID-15, TOP-20, 30, 25);

    }

    public static void drawBackground(Graphics g){
        final int MID = -100;
        final int TOP = 450;
        g.setColor (Color.white);
        g.fillOval (MID-20, TOP+15, 1000, 620);
        g.setColor (new Color(204,204,204));
        g.fillOval (MID-20, TOP, 600, 400);
        g.setColor (new Color(240,240,240));
        g.fillOval (MID+300, TOP+15, 1000, 620);
    }
    public static void drawXmasString(Graphics g){
        g.setFont(new Font("Monotype Corsiva", Font.BOLD, 60));
        g.setColor(new Color(225,175,55));
        g.drawString("Merry Christmas",20,80);
    }
}
