import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrzystanekList {
    List<Przystanek> units = new ArrayList<>();

    public PrzystanekList() {
    }

    public PrzystanekList(Stream<Przystanek> PStream) {
        units = PStream.collect(Collectors.toList());
    }

    public void read(String filename) throws IOException {
        CSVReader reader = new CSVReader(filename, ";", true);

        while (reader.next()) {
            Przystanek au = new Przystanek();

            if (!reader.isMissing(0)) {
                au.lp = reader.getInt(0);
            }
            if (!reader.isMissing(1)) {
                au.nazwa = reader.get(1);
            }
            if (!reader.isMissing(2)) {
                au.droga = reader.get(2);
            }
            if (!reader.isMissing(3)) {
                au.kilometraz = reader.get(3);
            }
            if (!reader.isMissing(4)) {
                au.lat = reader.getDouble(4);
            }
            if (!reader.isMissing(5)) {
                au.lon = reader.getDouble(5);
            }
            units.add(au);
        }
    }

    public void list(PrintStream out) {
        for (Przystanek a : units) {
            out.println(a.toString());
        }
    }

    PrzystanekList filter(Predicate<Przystanek> pred) { //referencja do interfejsu Predicate
        return new PrzystanekList(units.stream().filter(pred));
    }


    PrzystanekList sortInplaceByName() {
        Comparator<Przystanek> com = Comparator.comparing(a -> a.nazwa);
        units.sort(com);
        return this;
    }

    PrzystanekList sortInplaceByKm() {
        Comparator<Przystanek> com = Comparator.comparing(a -> a.kilometraz);
        units.sort(com);
        return this;
    }


}

