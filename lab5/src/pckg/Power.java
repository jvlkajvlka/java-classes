package pckg;

public class Power extends Node {
    public double p;
    public Node arg;
    Power(Node n,double p){
        arg = n;
        this.p = p;
    }

    @Override
    double evaluate() {
        double argVal = arg.evaluate();
        return Math.pow(argVal,p);
    }


    int getArgumentsCount(){return 1;}


    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        if(sign<0)b.append("-");
        int argSign = arg.getSign();
        int cnt = arg.getArgumentsCount();
        boolean useBracket = false;
        if(argSign<0 ||cnt>1)useBracket = true;
        String argString = arg.toString();
        if(useBracket)b.append("(");
        b.append(argString);
        if(useBracket)b.append(")");
        b.append("^");
        b.append(p);
        return b.toString();
    }
    @Override
    public Node diff(Variable v)
    {
        return (new Prod(sign*p, new Power(arg, p - 1))).mul(arg.diff(v));
    }

    @Override
    boolean isDiffZero(Variable variable) {
        return false;
    }

}
