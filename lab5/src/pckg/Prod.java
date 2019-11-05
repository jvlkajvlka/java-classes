package pckg;

import java.util.ArrayList;
import java.util.List;

public class Prod extends Node {
    List<Node> args = new ArrayList<>();

    Prod(){}

    Prod(Node n1){
        args.add(n1);
    }
    Prod(double c){
//        wywołaj konstruktor jednoargumentowy przekazując new Constant(c)
        Constant newConst= new Constant(c);
        args.add(newConst);
    }

    Prod(Node n1, Node n2){
        args.add(n1);
        args.add(n2);
    }
    Prod(double c, Node n){
//        wywołaj konstruktor dwuargumentowy
        Constant newConst= new Constant(c);
        args.add(newConst);
        args.add(n);
    }

    Prod mul(Node n){
        args.add(n);
        return this;
    }

    Prod mul(double c){
        Constant newConst= new Constant(c);
        args.add(newConst);
        return this;
    }


    @Override
    double evaluate() {
        double result =1;
        // oblicz iloczyn czynników wołąjąc ich metodę evaluate
        for(Node n : args)
        {
            result*=n.evaluate();
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
            b.append(n.toString());
            b.append("*");
        }
        if(sign<0)b.append(")");
        return b.toString();
    }

}
