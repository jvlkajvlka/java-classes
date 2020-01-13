import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tree {
    static List<XmasShape> treeShapes = new ArrayList<>();


    Tree() {
        drawTrunk();
        dramTree();
        drawBubble();
        drawStar();


    }

    public static void dramTree(){
        Branch br1 = new Branch(500, 100, 75, new Color(0, 150, 10));
        treeShapes.add(br1);
        Branch br2 = new Branch(500, 140, 60, new Color(0, 140, 10));
        treeShapes.add(br2);
        Branch br3 = new Branch(500, 180, 45, new Color(0, 130, 10));
        treeShapes.add(br3);
        Branch br4 = new Branch(500, 220, 30, new Color(0, 120, 10));
        treeShapes.add(br4);
        Branch br5 = new Branch(500, 260, 15, new Color(0, 110, 10));
        treeShapes.add(br5);
        Branch br6 = new Branch(500, 300, 0, new Color(0, 100, 10));
        treeShapes.add(br6);
    }
    public static void drawBubble() {
        int k;
        Random generator = new Random();
        for (k = 3; k < 6; k++) {
            for (int i = 0; i < 3; i++) {
                int rand1 = generator.nextInt(20);
                int rand2 = generator.nextInt(5);
                Bubble b = new Bubble(5 * rand1 + 450, 15 * rand2 + k * 80, 1, new Color(255, 193, 51));
                treeShapes.add(b);
            }
            for (int i = 0; i < 3; i++) {
                int rand1 = generator.nextInt(20);
                int rand2 = generator.nextInt(5);
                Bubble b = new Bubble(5 * rand1 + 450, 15 * rand2 + k * 75, 1, new Color(204, 102, 255));
                treeShapes.add(b);
            }
            for (int i = 0; i < 3; i++) {
                int rand1 = generator.nextInt(20);
                int rand2 = generator.nextInt(5);
                Bubble b = new Bubble(5 * rand1 + 450, 20 * rand2 + k * 70, 1, new Color(230, 0, 0));
                treeShapes.add(b);
            }
        }


    }
    public static void drawStar() {
        Star s = new Star(420, -110, new Color(255, 254, 113));
        treeShapes.add(s);
    }
    public static void drawTrunk(){
        Trunk t = new Trunk(235, 225, new Color(100, 80, 40));
        treeShapes.add(t);
    }
}
