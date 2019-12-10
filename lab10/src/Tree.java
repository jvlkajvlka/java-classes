import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Tree {
    List<XmasShape> treeShapes = new ArrayList<>();

    Tree(){
        Branch br1 = new Branch(500,100,75,new Color(0,100,10));
        treeShapes.add(br1);
        Branch br2 = new Branch(500,140,60,new Color(0,100,10));
        treeShapes.add(br2);
        Branch br3 = new Branch(500,180,45,new Color(0,100,10));
        treeShapes.add(br3);
        Branch br4 = new Branch(500,220,30,new Color(0,100,10));
        treeShapes.add(br4);
        Branch br5 = new Branch(500,260,15,new Color(0,100,10));
        treeShapes.add(br5);
        Branch br6 = new Branch(500,300,0,new Color(0, 100, 10));
        treeShapes.add(br6);

    }


}
