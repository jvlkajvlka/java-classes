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


   public String toString(){
       StringBuilder buf = new StringBuilder(String.format(this.name, this.adminLevel, this.population, this.area, this.density));
      return buf.toString();
   }

    protected void fixMissingValues(){
        if(this.density == 0 && this.parent != null){
            if(this.parent.density == 0) {
                this.parent.fixMissingValues();
            }
            this.density = this.parent.density;
        }
        if(this.population == 0){
            this.population = this.area*this.density;
        }
    }

}