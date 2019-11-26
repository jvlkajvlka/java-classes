package files;

public class BoundingBox {
    Double xmin;
    Double ymin;
    Double xmax;
    Double ymax;

    /**
     * Powiększa BB tak, aby zawierał punkt (x,y)
     * @param x - współrzędna x
     * @param y - współrzędna y
     */
    void addPoint(double x, double y){
        if(this.isEmpty()){
            xmin=x;
            xmax=x;
            ymin=y;
            ymax=y;
        }else{
            if(x>xmax) xmax=x;
            if(x<xmin) xmin=x;
            if(y>ymax) ymax=y;
            if(y<ymin) ymin=y;
        }

    }

    /**
     * Sprawdza, czy BB zawiera punkt (x,y)
     * @param x
     * @param y
     * @return
     */
    boolean contains(double x, double y){
        return !this.isEmpty() &&  x >= xmin && x <= xmax && y >= ymin && y <= ymax;
    }

    /**
     * Sprawdza czy dany BB zawiera bb
     * @param bb
     * @return
     */
    boolean contains(BoundingBox bb){
        return xmin<=bb.xmin && xmax>=bb.xmax && ymin<=bb.ymin && ymax>=bb.ymax;
    }

    /**
     * Sprawdza, czy dany BB przecina się z bb
     * @param bb
     * @return
     */
    boolean intersects(BoundingBox bb){
       if(this.isEmpty() && bb.isEmpty()){
          if((this.xmin)>(bb.xmax) || (this.xmax<bb.xmin) || (this.ymax)>(bb.ymin) || (this.ymin)<bb.ymax) return true;
       }
       return false;
    }
    /**
     * Powiększa rozmiary tak, aby zawierał bb oraz poprzednią wersję this
     * @param bb
     * @return
     */
    BoundingBox add(BoundingBox bb){
        if(!this.contains(bb)){
          addPoint(bb.xmax,bb.ymax);
          addPoint(bb.xmin,bb.ymin);
        }
        return this;
    }
    /**
     * Sprawdza czy BB jest pusty
     * @return
     */
    boolean isEmpty(){
        return xmax.isNaN() || xmin.isNaN() || ymax.isNaN() || ymin.isNaN();
    }

    /**
     * Oblicza i zwraca współrzędną x środka
     * @return if !isEmpty() współrzędna x środka else wyrzuca wyjątek
     * (sam dobierz typ)
     */
    double getCenterX(){
        if(this.isEmpty()){
            throw new RuntimeException("Not implemented");
        }
        return (xmax+xmin)/2;
    }
    /**
     * Oblicza i zwraca współrzędną y środka
     * @return if !isEmpty() współrzędna y środka else wyrzuca wyjątek
     * (sam dobierz typ)
     */
    double getCenterY(){
        if(this.isEmpty()){
            throw new RuntimeException("Not implemented");
        }
        return (ymax+ymin)/2;
    }



    public static double haversine(double lat1, double lon1, double lat2, double lon2) {
        final double R = 6372.8; // In kilometers
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double a = Math.pow(Math.sin(dLat / 2), 2) + Math.pow(Math.sin(dLon / 2), 2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return R * c;
    }
    /**
     * Oblicza odległość pomiędzy środkami this bounding box oraz bbx
     * @param bbx prostokąt, do którego liczona jest odległość
     * @return if !isEmpty odległość, else wyrzuca wyjątek lub zwraca maksymalną możliwą wartość double
     * Ze względu na to, że są to współrzędne geograficzne, zamiast odległosci euklidesowej możesz użyć wzoru haversine
     * (ang. haversine formula)
     */
    double distanceTo(BoundingBox bbx){
        if(this.isEmpty()){
            throw new RuntimeException("Not implemented");
        }
            return haversine(this.getCenterY(),this.getCenterX(), bbx.getCenterY(), bbx.getCenterX());

    }

}

