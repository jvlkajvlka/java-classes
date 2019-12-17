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
        setBackground(new Color(3,215,252));
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

        g.setFont(new Font("Monotype Corsiva", Font.BOLD, 60));
        g.setColor(new Color(121,126,149));
        g.drawString("Merry Christmass",20,80);
        for(XmasShape s:shapes){
            s.draw((Graphics2D)g);
         }



    }

}