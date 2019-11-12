package files;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        CSVReader reader = new CSVReader("titanic-part.csv",",",true);
        while(reader.next()){
            int id = reader.getInt("PassengerId");
            String name = reader.get("Name");
            double fare = reader.getDouble("Fare");

            System.out.printf(Locale.Us,"%d %s %d",id, name, fare);
        }

        CSVReader reader = new CSVReader("titanic-part.csv",",",true);
        while(reader.next()){
            int id = reader.getInt(0);
            String name = reader.get(3);
            double fare = reader.getDouble(9);
            System.out.printf(Locale.Us,"%d %s %d",id, name, fare);

        }

    }
}
