package section2;

public class Term3 {
    public int coef;
    public int expo;

    // 생성자
    // 클스 자체의 이름과 동일
    // return 타입이 없다.

    // 객체를 생성할 때 자동으로 실행된다.
    // 일종의 메소드
    // 목적: 객체 안에 들어있는 데이터 필드 값으로 초기화 하고 싶을 때 사용한다.
    // 사용 Term3 t2 = new Term3(3,2)

    public Term3(int c, int e)
    {
        coef = c;
        expo = e;
    }

    int calcTerm( int x_){
        double x=0;
        return (int) (coef*Math.pow(x, expo));
    }
    void printTerm(){
        System.out.print(coef + "x^"+expo);
    }
}
