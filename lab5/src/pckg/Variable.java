package pckg;

public class Variable extends Node {
    String name;
    Double value;
    Variable(String name){
        this.name = name;
    }
    void setValue(double d){
        value = d;
    }


    @Override
    double evaluate() {
        return sign*value;
    }


    @Override
    public String toString() {
        String sgn=sign<0?"-":"";
        return sgn+name;
    }

    public String getName() {
        return name;
    }

    @Override
    boolean isDiffZero(Variable variable) {
        return !variable.getName().equals(name);
    }

    @Override
    Node diff(Variable variable) {
        if (variable.getName().equals(name)) {
            return new Constant(1);
        }
        return new Constant(0);
    }


}