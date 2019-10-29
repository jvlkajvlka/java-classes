package files;

public class Main {
    public static void main(String[] args){
        Matrix m = new Matrix(new double[][]{{1,2,3,4},{5,6},{7,8},{9}});
        m.asArray();
        //System.out.print(m.toString());
       // m.reshape(2,8);
      //  m.asArray();
      //  System.out.print(m.toString());
        System.out.print(m.shape()[0]);//[0] daje 4

    }


}
