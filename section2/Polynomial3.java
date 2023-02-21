package section2;

public class Polynomial3 {
    public char name;
    public int nTerms=0;
    public Term3[] terms;

    // 생성자가 있다면 생성자 안에서 하는 게 더 적절해보인다.
    // 2개 이상의 생성자를 가질 수 있다.
    // 매개변수를 받지 않는 생성자
    public Polynomial3()
    {
        nTerms = 0;
        terms = new Term3[100];
    }

    // 매객변수를 받는 생성자
    public Polynomial3( char name )
    {
        this.name = name;
        nTerms = 0;
        terms = new Term3[100];
    }


    public void addTerm(int c, int e) {
        int index = findTerm( c );
        if (index != -1){
            terms[index].coef += c;  // -5x^3 + 5x^3 = 0;
        }
        else {
            int i = nTerms-1;
            while (i>=0 && terms[i].expo < e){
                terms[i+1] = terms[i];
                i--;
            }
            terms[i+1] = new Term3(c, e);  // 이거 만들고 가자구!
            nTerms++;
        }
    }
    public int findTerm( int e ) {
        for (int i=0; i< nTerms && terms[i].expo >=e; i++){
            if(terms[i].expo == e){
                return i;
            }
        }
        return -1;
    }
    public int calcPolynomial( int x ) {
        int result = 0;
        for (int i =0; i< nTerms; i++)
            result += terms[i].calcTerm(x);
        return result;
    }
    public void printPolynomial() {
        for (int i=0; i< nTerms; i++){
            terms[i].printTerm();
            System.out.print("+");
        }
        System.out.println();
    }
}
