package communication;

// 내부클래스가 메모리에 언제 뜰까

class A{
    
    int num =10;

    class B {
        int num2 = 20;
    }
}

// 내부클래스는, 담고 있는 클래스 외, 외부에서 사용될 때 없을 때 쓰는 거임

public class InnerTest {

    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.num);
        
        // B는 어떻게 접근하는가? a. 해도 B가 없음
//        A.B b = a.getB();
// 하지말재 햇갈린다고

    }

}
