package section1;

public class Code01 {
    public static void main(String[] args) {
        Person1 first;  // 하나의 Person1 타입
        first = new Person1();  // 객체(object)를 생성하고 얘를 first라고 한다.

        first.name = "john";  // .연산자를 이용해서 저장
        first.number = "0101234568";

        System.out.println("Name: " + first.name+", "+"Number: "+first.number);  // 출력

        Person1[] members = new Person1 [100];  // Person1 타입의 배열도 만들 수 있다.
        members[0] = first;
        members[1] = new Person1();
        members[1].name = "David";  //
        members[1].number = "232321233";

        System.out.println("Name: " + members[1].name+", "+"Number: "+members[1].number);
    }
}
