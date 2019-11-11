package files;

public class Matrix {
    double[]data;
    int rows;
    int cols;

    Matrix(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        data = new double[rows*cols];
    }

    Matrix(double[][] d){
        this.rows = d.length;
        for (int i=0; i<this.rows; i++){
            {
                if (d[i].length > this.cols) {
                    this.cols = d[i].length;
                }
            }
        }
        data = new double [this.rows*this.cols];

        for(int i = 0 ; i<this.rows; i++){
            for(int j = 0; j < d[i].length; j++){
                data[i*this.cols + j]=d[i][j];
            }
        }
    }

    double[][] asArray(){
        double [][] newArray = new double[rows][cols];
        for(int i = 0 ; i<this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                newArray[i][j] = data[i * cols + j];

            }
        }
        return newArray;
    }

    double get(int r, int c){
        return data[r*cols + c];
    }

    void set(int r, int c, double value){
        data[r*cols + c] = value;
    }

    public String toString(){
        StringBuilder buf = new StringBuilder();
        buf.append("[");
        for(int i=0;i<rows;i++){
            buf.append("[");
            for( int j = 0; j< cols ;j++){
                buf.append("["+(data[i*cols+j])+"]");
            }
            buf.append("]\n");

        }
        buf.append("]");
        return buf.toString();
    }

    void reshape(int newRows,int newCols){
        if(rows*cols != newRows*newCols)
            throw new RuntimeException(String.format("%d x %d matrix can't be reshaped to %d x %d",rows,cols,newRows,newCols));
         this.rows = newRows ;
         this.cols = newCols;

    }

    int[] shape(){
       return new int[]{rows,cols};
    }

    Matrix add(Matrix m){

        if(rows*cols != m.rows*m.cols)
            throw new RuntimeException(String.format("%d x %d matrix can't be add to %d x %d",rows,cols,m.rows,m.cols));
        for(int i=0;i<rows;i++){
            for( int j = 0; j< cols ;j++) {
                this.set(i,j,this.get(i,j)+m.get(i,j));
            }
        }
        return this;
    }

    Matrix sub(Matrix m){
        if(rows*cols != m.rows*m.cols)
        throw new RuntimeException(String.format("%d x %d matrix can't be add to %d x %d",rows,cols,m.rows,m.cols));
        for(int i=0;i<rows;i++){
            for( int j = 0; j< cols ;j++) {
                this.set(i,j,this.get(i,j)-m.get(i,j));
            }
        }
        return this;
    }

    Matrix mul(Matrix m){
        if(rows*cols != m.rows*m.cols)
            throw new RuntimeException(String.format("%d x %d matrix can't be add to %d x %d",rows,cols,m.rows,m.cols));
        for(int i=0;i<rows;i++){
            for( int j = 0; j< cols ;j++) {
                this.set(i,j,this.get(i,j)*m.get(i,j));
            }
        }
        return this;
    }

    Matrix div(Matrix m){
        if(rows*cols != m.rows*m.cols)
            throw new RuntimeException(String.format("%d x %d matrix can't be add to %d x %d",rows,cols,m.rows,m.cols));
        for(int i=0;i<rows;i++){
            for( int j = 0; j< cols ;j++) {
                this.set(i,j,this.get(i,j)/m.get(i,j));
            }
        }
        return this;
    }

    Matrix dot(Matrix m){
        if(this.cols!=m.rows){
            throw new  RuntimeException(String.format("Can't be dot :( "));
        }
        Matrix newMatrix = new Matrix(this.rows,m.cols);

        for(int i = 0 ; i<newMatrix.rows ; i++){
            for(int j = 0; j<newMatrix.cols ;j++){
                for (int k = 0; k<this.cols; k++) {
                    newMatrix.data[i*newMatrix.cols+j] += this.get(i,k)+m.get(k,j);
                }
            }
        }

        return newMatrix;
    }


}







