package communication;

import java.io.IOException;
import java.io.InputStream;

public class InputEx01 {
    public static void main(String[] args) {
        // 바이트스트림
        // 자동으로 오버라이드?
        InputStream in = System.in; // 키보드로부터 연결된 선, 무조건 키보드임
        // in.read하면 try-catch하라고 뜸, int 타입을 리턴함
        try {
            int number = in.read(); // bit가 들어옴, 바이트 스트림이기 때문에 8비트씩 끊어읽음
            // 실행되면, 키보드의 입력을 기다리면서 while이 계속 도는 거임. 얼마마다 while이 돌면서 작동하는지가 퍼포먼스에 영향을 도는 거임
            // while이 돌면서 대기한다 중요 = 리스너
            System.out.println((char)number); // 8->2btye로 다운 캐스팅
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
