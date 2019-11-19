package files;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminUnit {
    String name;
    int adminLevel;
    double population;
    double area;
    double density;
    AdminUnit parent;
    BoundingBox bbox = new BoundingBox();
    List<AdminUnit> children;
    Map<Long,List<AdminUnit>> parentid2child = new HashMap<>();

   public String toString(){
       StringBuilder buf = new StringBuilder(String.format(this.name, this.adminLevel, this.population, this.area, this.density));
      return buf.toString();
   }


}