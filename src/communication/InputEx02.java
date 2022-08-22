package communication;

import java.io.InputStream;
import java.io.InputStreamReader;

public class InputEx02 {
    public static void main(String[] args) {
        char[] arr = new char[1];
        // 배열 사용하는 stream
        // 크기 늘린 만큼 나옴
        // 인풋스트림 사용할 때 트라이 캐치 필수

        try {
            InputStream in = System.in; // 8비트만 읽고 종료되는 클래스, 내부적으로 그렇게 설계 돼 있음

            InputStreamReader ir = new InputStreamReader(in); // 배열을 받는 것
            InputStreamReader ir2 = new InputStreamReader(System.in); // 이렇게 바로 넣을 수 있음(타입이 같으니까 노상관)

            ir.read(arr);

            System.out.println(arr[0]);
            // 캐스팅 필요 없이, 바로 출력할 수 있음.

        } catch (Exception e){

        }

        // 8비트만 읽고 나머지 버림 ;
        // 배열에 크기만큼 받아서 넣고, 남은 거는 버림, 배열이 남으면 그냥 거기서 끝냄
    }

}
