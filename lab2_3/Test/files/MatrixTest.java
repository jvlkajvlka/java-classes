package files;

import static org.junit.Assert.*;

public class MatrixTest {

    Matrix smallMatrix = new Matrix(new double[][] {
            {2, 4},
            {6, 8}
    });

    @org.junit.Test
    public void Matrix(){
        int row=2;
        int col=2;
        double[] d1 = new double[row*col];

        Matrix m1 = new Matrix(2,2);
        assertEquals(m1.data.length,d1.length);

    }

    @org.junit.Test
    public void Matrix_double(){
        double [][] d2 = new double[][]{{1,2,3},{4,5},{6}};
        Matrix m2 =new Matrix(d2);
        double[][] newArr = m2.asArray();
        assertEquals(newArr.length,m2.rows);
        assertEquals(newArr[2][1],m2.data[7],0);
    }

    @org.junit.Test
    public void asArray() {
        double [][] d3 = new double[][]{{1,2},{4,5},{7,8}};
        Matrix m3= new Matrix(d3);
        assertEquals(m3.rows,d3.length);

    }

    @org.junit.Test
    public void get() {
        double[][] d4 = new double[][]{{1,2,3},{4,5},{6,8}};
        Matrix m4= new Matrix(d4);
        assertEquals(m4.data[4],m4.get(1,1),0);
         }

    @org.junit.Test
    public void set() {
        double[][] d4 = new double[][]{{1,2,3},{4,5},{6,8}};
        Matrix m4= new Matrix(d4);
        m4.set(1,1,10);
        assertEquals(m4.data[4],10,0);
    }

    @org.junit.Test
    public void testToString() {
        String s= "[[1.0,2.3,4.56], [12.3,  45, 21.8]]";
        s= s.replaceAll("(\\[|\\]|\\s)+","");
        String[] t = s.split("(,)+");
        for(String x:t){
            System.out.println(String.format("\'%s\'",x ));
        }

        double[]d=new double[t.length];
        for(int i=0;i<t.length;i++) {
            d[i] = Double.parseDouble(t[i]);
        }

        double arr[][]=new double[1][];
        arr[0]=d;

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.println(arr[i][j]);
            }
        }
    }

    @org.junit.Test
    public void reshape() {
        int cols= 3;
        int rows = 2;
        Matrix d5 = new Matrix(cols,rows);
        int newCols = 5;
        int newRows = 4;
        try{d5.reshape(newRows,newCols);
            fail();
        }
            catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @org.junit.Test
    public void shape() {
        double [][] mat = new double[4][4];
        Matrix m = new Matrix(mat);
        int []mShape = m.shape();
        assertEquals(mShape[0],4);

    }

    @org.junit.Test
    public void add() {

        Matrix other = new Matrix(new double[][] {{1,1}, {1,1}});
        Matrix result = smallMatrix.add(other);

        assertEquals(result.data[0],3,0);
        assertEquals(result.data[3],9,0);



    }

    @org.junit.Test
    public void sub() {
        double [][] d6 = new double[][]{{1,2,3},{4,5}};
        double [][] d7 = new double[][]{{0,1,2},{3,4}};
        double [][] d8 = new double[][]{{1,1,1},{1,1}};
        Matrix m8 = new Matrix(d8);
        Matrix m6 = new Matrix(d6);
        Matrix m7 = new Matrix(d7);
        m6.sub(m7);

        assertArrayEquals(m6.data,m8.data,0);

    }

    @org.junit.Test
    public void mul() {

        Matrix other = new Matrix(new double[][] {{2, 2}, {2, 2}});
        Matrix result = smallMatrix.mul(other);
        Matrix toCheck = new Matrix(new double[][]{{4, 8},{12, 16}});
        for(int i=0; i<result.rows*result.cols; i++){
            assertEquals(result.data[i], toCheck.data[i],0);
        }


    }

    @org.junit.Test
    public void div() {
        Matrix other = new Matrix(new double[][] {{2, 2}, {2, 2}});
        Matrix result = smallMatrix.div(other);
        Matrix toCheck = new Matrix(new double[][]{{1,2},{3, 4}});
        for(int i=0; i<result.rows*result.cols; i++){
            assertEquals(result.data[i], toCheck.data[i],0);
        }
    }

    @org.junit.Test
    public void dot() {

       try{Matrix result = smallMatrix.dot(smallMatrix);
           Matrix toCheck = new Matrix(new double[][]{{28,40},{60,88}});
           for(int i=0; i<result.rows*result.cols; i++){
               assertEquals(result.data[i], toCheck.data[i],0);
           }
       }
       catch(Exception e){
           System.out.println(e.getMessage());
       }

    }

    @org.junit.Test
    public void eye(){
        assertEquals((smallMatrix.frobenius()), 120,0);
    }
}