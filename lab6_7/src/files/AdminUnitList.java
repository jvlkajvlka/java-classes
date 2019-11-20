package files;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.io.PrintStream;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AdminUnitList {
    List<AdminUnit> units = new ArrayList<>();
    Map<Long, AdminUnit> idToUnit = new HashMap<>();
    Map<AdminUnit, Long> unitToParentId = new HashMap<>();

    /**
     * Czyta rekordy pliku i dodaje do listy
     * @param filename nazwa pliku
     */

    public void read(String filename) throws IOException {
        CSVReader fileToRead = new CSVReader(filename, ",", true);
        while (fileToRead.next()) {
            AdminUnit au = new AdminUnit();
            if (!fileToRead.isMissing("name")) {
                au.name = fileToRead.get("name");
            }
            if (!fileToRead.isMissing("adminLevel")) {
                au.adminLevel = fileToRead.getInt("adminLevel");
            }
            if (!fileToRead.isMissing("population")) {
                au.population = fileToRead.getDouble("population");
            }
            if (!fileToRead.isMissing("area")) {
                au.area = fileToRead.getDouble("area");
            }
            if (!fileToRead.isMissing("density")) {
                au.density = fileToRead.getDouble("density");
            }
            units.add(au);
        }
    }

    /**
     * Wypisuje zawartość korzystając z AdminUnit.toString()
     * @param out
     */
    void list(PrintStream out){
            for (AdminUnit au : units) {
                out.println(au.toString());
            }
    }

    /**
     * Wypisuje co najwyżej limit elementów począwszy od elementu o indeksie offset
     * @param out - strumień wyjsciowy
     * @param offset - od którego elementu rozpocząć wypisywanie
     * @param limit - ile (maksymalnie) elementów wypisać
     */
    void list(PrintStream out,int offset, int limit ){
        for (int i = offset; i < (offset + limit); i++) {
            out.println(units.get(i).toString());
        }
    }

    /**
     * Zwraca nową listę zawierającą te obiekty AdminUnit, których nazwa pasuje do wzorca
     * @param pattern - wzorzec dla nazwy
     * @param regex - jeśli regex=true, użyj finkcji String matches(); jeśli false użyj funkcji contains()
     * @return podzbiór elementów, których nazwy spełniają kryterium wyboru
     */
    AdminUnitList selectByName(String pattern, boolean regex){
        AdminUnitList ret = new AdminUnitList();
        // przeiteruj po zawartości units
        // jeżeli nazwa jednostki pasuje do wzorca dodaj do ret
        for (AdminUnit a : units) {
            if (regex) {
                if (a.name.matches(pattern)) ret.units.add(a);
            } else {
                if (a.name.contains(pattern)) ret.units.add(a);
            }
        }
        return ret;
    }


    //uzupelnienie brakujacych wartosci dla wszystkich jednostek
    public void fixAll() {
        for (AdminUnit u : units) {
            u.fixMissingValues();
        }
    }

}
