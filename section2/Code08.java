package section2;

import java.util.Scanner;

public class Code08 {
    static Polynomial3[] polys = new Polynomial3[100];  // 입력한 다항식을 보관할 배열
    static int n  =0;  // 보관된 다항식의 개수

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        while (true) {
            System.out.println("$ ");
            String command = kb.next();
            if(command.equals("create")){
                char name = kb.next().charAt(0);

                polys[n] = new Polynomial3();
                polys[n].name = name;
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
                    polys[index].addTerm(c, e);  // polys[index]이건 좀 이해안가나?..
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
                    int result = polys[index].calcPolynomial( x );
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

    private static int find(char name) {
        for (int i=0; i<n; i++){
            if(polys[i].name == name)
                return i;
        }
        return -1;
    }
}