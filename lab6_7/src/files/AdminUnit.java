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

    void fixMissingValues() {
        if (density != -1 && population != -1) {
            return;
        }

        AdminUnit parentUnit = parent;

        while (parentUnit != null) {
            if (parentUnit.density == -1) {
                parentUnit = parentUnit.parent;
            } else {
                break;
            }
        }

        if (parentUnit == null) {
            return;
        }

        density = parentUnit.density;
        population = area * density;
    }

    @Override
    public String toString() {
        return "AdminUnit{"
                + "name='"
                + name
                + '\''
                + ", adminLevel="
                + adminLevel
                + ", population="
                + population
                + ", area="
                + area
                + ", density="
                + density
                + ", parent="
                + parent
                + ", bbox="
                + bbox
                + '}';
    }

}