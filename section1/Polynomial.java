package section1;

public class Polynomial {
    public char name;
    public int nTerms=0;
    public Term[] terms;
    int calcPolynomial(int x) {
        int result = 0;
        for (int i =0; i< nTerms; i++)
            result += terms[i].calcTerm(x);
        return result;
    }
    void printPolynomial() {
        for (int i=0; i< nTerms; i++){
            terms[i].printTerm();
            System.out.print("+");
        }
        System.out.println();
    }
}
