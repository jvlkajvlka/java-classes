import java.util.Comparator;
import java.util.List;

public class Przystanek {
    int lp;
    String nazwa;
    String droga;
    String kilometraz;
    double lat;
    double lon;



    @Override
    public String toString() {
        return "Przystanek{" +
                "lp=" + lp +
                ", nazwa='" + nazwa + '\'' +
                ", droga='" + droga + '\'' +
                ", kilometraz='" + kilometraz + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }

    boolean sortbyArea(){
        double ltMax=50.62;
        double ltMin=50.54;
        double lnMax=21.73;
        double lnMin=21.63;
        if(lat<ltMax && lat>ltMin && lon<lnMax && lon>lnMin){
            return true;
        }
        return false;
    }

    public Double getLat(){
        return lat;
    }
    public Double getLon(){
        return lon;
    }

}
