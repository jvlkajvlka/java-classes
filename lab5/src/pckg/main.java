package pckg;

import java.util.Locale;

public class main {
    public static void main(String[] args) {

        buildAndPrint();
        buildAndEvaluate();
        defineCircle();

    }

    static void buildAndPrint(){
        Variable x = new Variable("x");
        Node exp = new Sum()
                .add(2.1,new Power(x,3))
                .add(new Power(x,2))
                .add(-2,x)
                .add(7);
        System.out.println(exp.toString());

    }

    static void buildAndEvaluate() {
        Variable x = new Variable("x");
        Node exp = new Sum()
                .add(new Power(x, 3))
                .add(-2, new Power(x, 2))
                .add(-1, x)
                .add(2);
        for (double v = -5; v < 5; v += 0.1) {
            x.setValue(v);
            System.out.printf(Locale.US, "f(%f)=%f\n", v, exp.evaluate());
        }
    }

    static void defineCircle() {
        Variable x = new Variable("x");
        Variable y = new Variable("y");
        Node circle = new Sum()
                .add(new Power(x, 2))
                .add(new Power(y, 2))
                .add(8, x)
                .add(4, y)
                .add(16);
        System.out.println(circle.toString());
        int count = 0;
        while (count < 100) {
            double xv = 100 * (Math.random() - .5);
            double yv = 100 * (Math.random() - .5);
            x.setValue(xv);
            y.setValue(yv);

            double fv = circle.evaluate();
            if(fv<0){
                System.out.print(String.format("%d Punkt (%f,%f) leży %s koła %s \n", count+1, xv, yv, (fv < 0 ? "wewnątrz" : "na zewnątrz"), circle.toString()));
                count+=1;
            }
        }

    }

}
