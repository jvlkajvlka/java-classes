import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {


        PrzystanekList ls = new PrzystanekList();
        ls.read("przystanki.csv");
        //ls.list(System.out);

        //Przystanki przy drogach na P
     //  ls.filter(a->a.droga.contains("P")).list(System.out);

       //przystanki wewnatrz obszaru , posortowane wedlug nazwa

        double ltMax=50.62;
        double ltMin=50.54;
        double lnMax=21.73;
        double lnMin=21.63;
        ls.filter(a -> a.lat < ltMax).filter(a->a.lat>lnMin).filter(a->a.lon<lnMax).filter(a->a.lon>lnMax).sortInplaceByName().list(System.out);

//DRUGA WERSJA
//        List<Przystanek> includels= new ArrayList<>();
//        for(Przystanek l : ls.units){
//            if (l.sortbyArea()){
//                includels.add(l);
//            }
//        }
//        for(int i = 0; i<includels.size();i++){
//            System.out.print(includels.get(i));
//        }


// Warszawska + kilomatraz
      //  ls.filter(a->a.nazwa.contains("Warszawska")).sortInplaceByKm().list(System.out);

        Przystanek lMax= ls.units.stream().max(Comparator.comparing(Przystanek::getLat)).get();

        Przystanek lMin=ls.units.stream().min(Comparator.comparing(Przystanek::getLat)).get();

        Przystanek nMin=ls.units.stream().min(Comparator.comparing(Przystanek::getLon)).get();

        Przystanek nMax=ls.units.stream().max(Comparator.comparing(Przystanek::getLon)).get();

        class Box{
            double x;
            double y;
            double z;
            double q;

        }

        Box b = new Box;
        b.x=lnMax.lat;


    }

}




