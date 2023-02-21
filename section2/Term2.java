package section2;

public class Term2 {
    public int coef;
    public int expo;

    public int calcTerm( int x_){
        double x=0;
        return (int) (coef*Math.pow(x, expo));
    }
    public void printTerm(){
        System.out.print(coef + "x^"+expo);
    }
}
