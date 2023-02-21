package section1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Code03 {
    static Person1[] members = new Person1[100];
    static int n = 0;
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(new File("input.txt"));
            while( in.hasNext()) {
                String nm = in.next();
                String nb = in.next();
                members[n] = new Person1();
                members[n].name = nm;
                members[n].number = nb;
                n++;
            }
            in.close();
        } catch (FileNotFoundException e){
            System.out.println("No data file");
        }

        bubbleSort();

        for (int i=0; i<n; i++){
            System.out.println(members[i].name+" "+members[i].number);
        }
    }

    private static void bubbleSort() {
        for(int i=n-1; i>0; i--){
            for(int j=0; j<i; j++){
                if( members[j].name.compareTo(members[j+1].name) > 0){  // compare names of j-th and (j+1)-th person
                    // swap two person
                    Person1 tmp = members[j];  // Person1 tmp의 객체를 만들지 않아도 될까?
                    members[j] = members[j+1];  // 지금 주소끼리 복사하고 있다는 걸 알아두자.
                    members[j+1] = tmp;
                }
            }
        }
    }

}
