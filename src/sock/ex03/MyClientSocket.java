package sock.ex03;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

// 헤더데이터와 프로토콜에 대해
// 헤더데이터 통신에 필요한 데이터
// 바디데이터 : 실제 보낼 내용

public class MyClientSocket {

    Socket socket;
    public void init(){
        try {
            socket = new Socket("localhost", 10000);

            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

            // 입력을 계속 받기 위한 구현
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while(true){
                String keyboardMsg = br.readLine(); // 키보드 엔터를 누를 때까지
                MyDto dto = new MyDto(1, "성공", keyboardMsg); // code, msg가 헤더 데이터, keyboard가 바디데이터 ; http 통신엔 이미 이런 헤더데이터가 존나게 많음
                // 이상태로 하면 이상한 값 보냄 -> 자바 객체는 못 읽으니까 당연히 => 제이슨으로 파싱해야 됨

                Gson gson = new Gson();
                String sendData = gson.toJson(dto);


                pw.println(sendData);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyClientSocket ms = new MyClientSocket();
        ms.init();
    }
}
