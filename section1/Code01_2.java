package section1;

public class Code01_2 {
    public static void main(String[] args) {
        Person1 first;  // 하나의 Person1 타입
        first = new Person1();  // 객체(object)를 생성하고 얘를 first라고 한다.

        first.name = "john";  // .연산자를 이용해서 저장
        first.number = "0101234568";
        System.out.println("Name: " + first.name+", "+"Number: "+first.number);  // 출력

        Person1 second;
        second = first;  // second라는 참조변수에 first의 주소를 받으니까 동일한 객체를 참조
        second.name = "Tom"; // 이렇게 할 경우 참조하고 있는 second, first모두 바뀐다.

        System.out.println("Name: " + first.name+", "+"Number: "+first.number);  // 출력
//        System.out.println("Name: " + second.name+", "+"Number: "+second.number);  // 출력

        Person1[] members = new Person1 [100];  // Person1 타입의 배열도 만들 수 있다.
        members[0] = first;
        members[1] = second;
        System.out.println("Name: " + members[0].name+", "+"Number: "+members[0].number);
        System.out.println("Name: " + members[1].name+", "+"Number: "+members[1].number);

        members[2] = new Person1();
        members[2].name = "David";  // 어떤 객체도 참조하고 있지 않다.
        members[2].number = "23456778";
        System.out.println("Name: " + members[2].name+", "+"Number: "+members[2].number);
    }
}