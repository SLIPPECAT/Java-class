package section1;

public class Term {
    public int coef;
    public int expo;

    void printTerm(){
        System.out.print(coef + "x^"+expo);
    }
    double calcTerm( int x_){
        double x=0;
        return coef*Math.pow(x, expo);
    }
}
