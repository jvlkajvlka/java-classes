package pckg;

import java.util.ArrayList;
import java.util.List;

public class Sum extends Node {

    List<Node> args = new ArrayList<>();

    Sum(){}

    Sum(Node n1, Node n2){
        args.add(n1);
        args.add(n2);
    }


    Sum add(Node n){
        args.add(n);
        return this;
    }

    Sum add(double c){
        args.add(new Constant(c));
        return this;
    }

    Sum add(double c, Node n) {
        Node mul = new Prod(c,n);
        args.add(mul);
        return this;
    }

    @Override
    double evaluate() {
        double result =0;
//        oblicz sumę wartości zwróconych przez wywołanie evaluate skłądników sumy

        for(Node n : args)
        {
            result+=n.evaluate();
        }
        return sign*result;
    }

    int getArgumentsCount(){return args.size();}

    public String toString(){
        StringBuilder b =  new StringBuilder();
        if(sign<0)b.append("-(");
        Node n;
        //zaimplementuj
        for(int i = 0; i<args.size(); i++) {
            n = args.get(i);
            if( i!=0){
                b.append("+");
            }
            if (n.sign < 0) {
                b.append("-");

            }
            b.append(n.toString());

        }
        if(sign<0)b.append(")");
        return b.toString();
    }

    @Override
    Node diff(Variable var) {
        Sum r = new Sum();
        for(Node n:args){
            r.add(n.diff(var));
        }
        return r;
    }

    @Override
    boolean isDiffZero(Variable variable) {
        return args.stream().allMatch(node -> node.isDiffZero(variable));
    }
}
