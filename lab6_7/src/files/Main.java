package files;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws IOException
    {
        // ---------------test CSVREADER---------------------------//
//        CSVReader reader = null;
//        try {
//            reader = new CSVReader("titanic-part.csv", ",", true);
//        }
//        catch (FileNotFoundException e) { e.printStackTrace(); }
//        if (reader == null)
//            return;
//        while (reader.next())
//        {
//            String id = reader.get("PassengerId");
//            String name = reader.get("Name");
//            String fare = reader.get("Fare");
//            System.out.printf("%s \t| %s \t| %s\n", id, name, fare);
//        }
        try {
        AdminUnitList ls = new AdminUnitList();
        ls.read("admin-units.csv");
//        ls.list(System.out, 0, 5);
        AdminUnit lsl = ls.units.get(1);
        AdminUnitList Lsl = ls.getNeighbors(lsl, 100);
        Lsl.list(System.out);
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }
        // ---------------test BoundingBox--------------------------//
//        BoundingBox box = new BoundingBox();
//        box.xmin = box.xmax = box.ymin = box.ymax = Double.NaN;
//        box.addPoint(10, 10);
//        System.out.println(box);

    }

}






