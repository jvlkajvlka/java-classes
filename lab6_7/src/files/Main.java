package files;

import java.io.IOException;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws IOException {
        CSVReader reader = new CSVReader("admin-units.csv",",",true);
        int counter = 0;
        while(reader.next() && counter<10){
           String name = reader.get(2);
            System.out.printf("%s\n", name);
            counter+=1;
        }

    }


}
