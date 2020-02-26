package files;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws IOException {

        AdminUnitList ls = new AdminUnitList();
        ls.read("admin-units.csv");
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
        //-------------------test wczytywanie/sąsiedzi--------------//
//        try {
//        AdminUnitList ls = new AdminUnitList();
//        ls.read("admin-units.csv");
//        ls.list(System.out, 0, 5);
//        AdminUnit lsl = ls.units.get(1);
//        AdminUnitList Lsl = ls.getNeighbors(lsl, 100);
//        Lsl.list(System.out);
//        } catch (IOException e) {
//            System.out.println("Something went wrong");
//        }

        // ---------------test BoundingBox--------------------------//
//        BoundingBox box = new BoundingBox();
//        box.xmin = box.xmax = box.ymin = box.ymax = Double.NaN;
//        box.addPoint(10, 10);
//        System.out.println(box);


        //----------------test adminUnitQuery---------------------//
//        AdminUnitQuery query = new AdminUnitQuery()
//                .selectFrom(ls)
//                .where(a->a.area>1000)
//                .or(a->a.name.startsWith("Sz"))
//                .sort((a,b)->Double.compare(a.area,b.area))
//                .limit(100);
//        query.execute().list(System.out);



       ls.list(System.out, 0, 100);
        ls.filter(a->a.name.startsWith("Ż")).sortInplaceByArea().list(System.out);
        ls.filter(a -> a.population < 1).filter(a -> a.name.startsWith("H")).list(System.out);
        ls.filter(a -> a.name.startsWith("W") || a.name.endsWith("o")).list(System.out);
        ls.filter(a -> a.name.startsWith("Żu") && a.name.endsWith("e"), 1, 3).list(System.out);


    }

}






