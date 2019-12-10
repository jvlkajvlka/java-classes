import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

import static java.awt.BasicStroke.CAP_ROUND;
import static java.awt.BasicStroke.JOIN_MITER;

public class DrawPanel extends JPanel {

    private List<XmasShape> shapes = new ArrayList<>();
    Tree tree;

    DrawPanel(){
        setBackground(new Color(3,215,252));
        setOpaque(true);
        Bubble b = new Bubble(10,10,1,new Color(255, 193, 51));

       Tree tree = new Tree();

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);



        for(XmasShape s:shapes){
            s.draw((Graphics2D)g);
         }


    }

}