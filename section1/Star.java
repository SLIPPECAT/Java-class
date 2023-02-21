package section1;
// 2, 1, 0 4-2a + = 5
public class Star {
    public static void main(String[] args) {
        // 앞쪽 띄어쓰기
        for (int a=0; a<3; a++){
            for (int i=0; i< 2-a; i++){
                System.out.print(' ');
            }
            // 별
            for (int j=0; j < 2*a+1;  j++){
                System.out.print('*');
            }
            // 뒤쪽 띄어쓰기
            for (int i=0; i< 2-a; i++){
                System.out.print(' ');
            }
            System.out.println();
        }
        for (int a=1; a>=0; a--){
            for (int i=0; i< 2-a; i++){
                System.out.print(' ');
            }
            // 별
            for (int j=0; j < 2*a+1;  j++){
                System.out.print('*');
            }
            // 뒤쪽 띄어쓰기
            for (int i=0; i< 2-a; i++){
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}

//    *
//   **
//  ***
// ****
//*****

// i,j,i
// i=k, 2i+j=5
// 띄어쓰기 2개 * 1개 띄어쓰기 2개
// 띄어쓰기 1개 * 3개 띄어쓰기 1개
// 띄어쓰기 0개 * 5개 띄어쓰기 0개
// 띄어쓰기 1개 * 3개 띄어쓰기 1개
// 띄어쓰기 2개 * 1개 띄어쓰기 2개
// 띄어쓰기랑 별이랑 합쳐서 5개


