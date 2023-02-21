package section1;

import java.util.Scanner;

public class Code06 {
    static Polynomial[] polys = new Polynomial[100];  // 입력한 다항식을 보관할 배열
    static int n  =0;  // 보관된 다항식의 개수

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        while (true) {
            System.out.println("$ ");
            String command = kb.next();
            if(command.equals("create")){
                char name = kb.next().charAt(0);

                polys[n] = new Polynomial();
                polys[n].name = name;
                polys[n].terms = new Term[100];
                polys[n].nTerms = 0;
                n++;
            }
            else if(command.equals("add")){  // add f 2 3
                char name = kb.next().charAt(0);
                int index = find(name);  //
                if(index==-1){
                    System.out.println("No such polynomial exists.");
                }
                else {
                    int c = kb.nextInt();  // coef
                    int e = kb.nextInt();  // expo
                    addTerm( polys[index], c, e);  // polys[index]이건 좀 이해안가나?..
                }
            }
            else if(command.equals("calc")) {
                char name = kb.next().charAt(0);
                int index = find(name);  //
                if (index == -1) {
                    System.out.println("No such polynomial exists.");
                }
                else{
                    int x = kb.nextInt();
                    int result = polys[index].calcPolynomial(x);
                    System.out.println(result);
                }
            }

            else if(command.equals("print")){
                char name = kb.next().charAt(0);
                int index = find(name);
                if (index==-1){
                    System.out.println("No such polynomial exists.");
                }
                else{
                    polys[index].printPolynomial();
                }
            }
            else if(command.equals("exit")){
                break;
            }
        }
        kb.close();
    }

    private static void addTerm(Polynomial p, int c, int e) {
        int index = findTerm( p, e );
        if (index != -1){
            p.terms[index].coef += c;  // -5x^3 + 5x^3 = 0;
        }
        else {
            int i = p.nTerms-1;
            while (i>=0 && p.terms[i].expo < e){
                p.terms[i+1] = p.terms[i];
                i--;
            }
            p.terms[i+1] = new Term();  // 이거 만들고 가자구!
            p.terms[i+1].coef = c;
            p.terms[i+1].expo = e;
            p.nTerms++;

        }
    }

    private static int findTerm(Polynomial p, int e) {
        for (int i=0; i< p.nTerms && p.terms[i].expo >=e; i++){
            if(p.terms[i].expo == e){
                return i;
            }
        }
            return -1;
    }

    private static int find(char name) {
        for (int i=0; i<n; i++){
            if(polys[i].name == name)
                return i;
        }
        return -1;
    }
}