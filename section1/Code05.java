package section1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code05 {

    static MyRectangle1[] rects = new MyRectangle1[100000];;
    static int n = 0;  // 사각형을 읽을 때마다 +1

    public static void main(String[] args) {
//        rects = new MyRectangle1[100000]; 여기도 가능
        try {
            Scanner in = new Scanner(new File("think.txt"));
            while(in.hasNext()){
                rects[n] = new MyRectangle1();
                rects[n].lu = new MyPoint1();
                // 위의 두 문장이 왜 필요한지 아는 게 중요하다.
                rects[n].lu.x = in.nextInt();  // x
                rects[n].lu.y = in.nextInt();  // y
                rects[n].width = in.nextInt();  // w
                rects[n].height = in.nextInt();  // h
                n++;
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("No data file.");
            System.exit(1);
        }
        bubbleSort();

        for (int i=0; i<n; i++)
            System.out.println(rects[i].lu.x+" "+rects[i].lu.y+" "+rects[i].width+" "+rects[i].height);
    }

    private static void bubbleSort() {
        for (int i=n-1; i>0; i--){
            for(int j=0; j<i; j++){
                // !계산하는 함수 만들어주기 길게 적으면 rects[i].width*rects[i].height
                if( calcArea(rects[j]) >  calcArea(rects[j+1]) ){
//                    rects[j+1] = new MyRectangle1();
                    MyRectangle1 tmp = rects[j];  // 사각형의 넓이가 큰 애를 맨 뒤로 보내준다.
                    rects[j+1] = rects[j];
                    rects[j] = tmp;
                }
            }
        }
    }
    public static int calcArea( MyRectangle1 r ){
        return r.width*r.height;
    }
}
