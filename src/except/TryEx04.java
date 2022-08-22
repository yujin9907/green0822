package except;

import java.io.IOException;

class Car{
    String name="소나타";
    void namePrint(){
        System.out.println(name);
    }
}

public class TryEx04 {

    public static void start(Car c) throws Exception{
        c.namePrint();
    }

    public static void start2(Car c) throws IOException{
        c.namePrint();
    }
    public static void main(String[] args) {
//        Car c = null; // c는 힙 메모리가 아니라 null을 가리키게 됨
//        c.namePrint(); // 실행하면 null에러
//
//        try {
//            start(null);
//            start2(null);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        try {
            start(null);
            start2(null);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
