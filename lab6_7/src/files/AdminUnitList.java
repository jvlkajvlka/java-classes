package files;
import java.io.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AdminUnitList {
    List<AdminUnit> units = new ArrayList<>();
    Map<Long, AdminUnit> idToUnit = new HashMap<>();
    Map<AdminUnit, Long> unitToParentId = new HashMap<>();

    public AdminUnitList() {
    }

    public AdminUnitList(Stream<AdminUnit> adminUnitStream) {
        units = adminUnitStream.collect(Collectors.toList());
    }

    public void read(String filename) throws FileNotFoundException, IOException {
        CSVReader reader = new CSVReader(filename);
        //id,parent,name,admin_level,population,area,density,x1,y1,x2,y2,x3,y3,x4,y4
        while (reader.next())
        {
            AdminUnit au = new AdminUnit();
            au.name = reader.get("name");
            au.adminLevel = reader.getInt("admin_level");
            au.population = reader.getDouble("population");
            au.area = reader.getDouble("area");
            au.density = reader.getDouble("density");
            au.bbox = new BoundingBox();
            au.bbox.xmin = reader.getDouble("x1");
            au.bbox.xmax = reader.getDouble("x3");
            au.bbox.ymin = reader.getDouble("y1");
            au.bbox.ymax = reader.getDouble("y3");
            units.add(au);
        }
        for (AdminUnit a : units) {
            if (unitToParentId.containsKey(a)) {
                Long parentId = unitToParentId.get(a);
                if (idToUnit.containsKey(parentId)) {
                    a.parent = idToUnit.get(parentId);
                    a.parent.children.add(a);
                }
            }
        }
    }
    public void list(PrintStream out) {
        for (var a : units) {
            out.printf(a.toString() +"\n");
        }
    }

    public void list(PrintStream out, int offset, int limit) {
        int i = 0;
        int printed = 0;
        for (var a : units) {
            if (i < offset) {
                i++;
                continue;
            }
            out.printf(a.toString()+"\n");
            printed++;
            if (printed >= limit)
                break;
        }
    }

    public AdminUnit get(int index) {
        return units.get(index);
    }

    public AdminUnitList selectByName(String pattern, boolean regex) {
        AdminUnitList output = new AdminUnitList();
        for (var a : units) {
            if (a.name.contains(pattern) || (regex && a.name.matches(pattern)))
                output.units.add(a);
        }
        return output;
    }

    //uzupelnienie brakujacych wartosci dla wszystkich jednostek
    public void fixAll() {
        for (AdminUnit u : units) {
            u.fixMissingValues();
        }
    }


    /*zwraca listę jednostek sąsiadujących z jendostką unit na tym samym poziomie hierarchii admin_level,
    maxdistance - parametr stosowany wyłącznie dla miejscowości, maksymalny promień odległości od środka unit,
    w którym mają sie znaleźć punkty środkowe BoundingBox sąsiadów*/
    AdminUnitList getNeighbors(AdminUnit unit, double maxdistance) {
        AdminUnitList neighborsList = new AdminUnitList();
        for (AdminUnit au : units) {
            if (au != unit) {
                if (unit.adminLevel == au.adminLevel) {
                    if (unit.adminLevel == 8) {
                        if (unit.bbox.distanceTo(au.bbox) < maxdistance) {
                            neighborsList.units.add(au);
                        }
                    } else {
                        if (unit.bbox.intersects(au.bbox)) {
                            neighborsList.units.add(au);
                        }
                    }
                }
            }
        }
        return neighborsList;
    }


    // -------------------SORTOWANIE--------------//
    /**
     * Sortuje daną listę jednostek (in place = w miejscu)
     * @return this
     */
    AdminUnitList sortInplaceByName() {
        Comparator<AdminUnit> com= Comparator.comparing(a->a.name);
        units.sort(com);
        return this;
    }


    /**
     * Sortuje daną listę jednostek (in place = w miejscu)
     * @return this
     */
    AdminUnitList sortInplaceByArea(){
        units.sort(new Comparator<AdminUnit>() {
            @Override
            public int compare(AdminUnit adminUnit, AdminUnit t1) {
                return Double.compare(adminUnit.area,t1.area);
            }
        });
       return this;
    }

    /**
     * Sortuje daną listę jednostek (in place = w miejscu)
     * @return this
     */
    AdminUnitList sortInplaceByPopulation(){
        units.sort((x,y)->Double.compare(x.population,y.population));
        return this;
    }


    AdminUnitList sortInplace(Comparator<AdminUnit> cmp){
        units.sort(cmp);
        return this;
    }


    AdminUnitList sort(Comparator<AdminUnit> cmp){
        // Tworzy wyjściową listę
        // Kopiuje wszystkie jednostki
        // woła sortInPlace
        AdminUnitList toOut = new AdminUnitList();
        Collections.copy(toOut.units, units);
        toOut.sortInplace(cmp);
        return toOut;
    }

//    //----------------------FILTROWANIE-------------//
    /**
     *
     * @param pred referencja do interfejsu Predicate
     * @return nową listę, na której pozostawiono tylko te jednostki,
     * dla których metoda test() zwraca true
     */
    AdminUnitList filter(Predicate<AdminUnit> pred){
        return new AdminUnitList(units.stream().filter(pred));
    }

    /**
     * Zwraca co najwyżej limit elementów spełniających pred
     * @param pred - predykat
     * @param limit - maksymalna liczba elementów
     * @return nową listę
     */
    AdminUnitList filter(Predicate<AdminUnit> pred, int limit){
        return new AdminUnitList(units.stream().filter(pred).limit(limit));

    }


    /**
     * Zwraca co najwyżej limit elementów spełniających pred począwszy od offset
     * Offest jest obliczany po przefiltrowaniu
     * @param pred - predykat
     * @param - od którego elementu
     * @param limit - maksymalna liczba elementów
     * @return nową listę
     */
    AdminUnitList filter(Predicate<AdminUnit> pred, int offset, int limit){
        return new AdminUnitList(units.stream().filter(pred).skip(offset).limit(limit));
    }

}