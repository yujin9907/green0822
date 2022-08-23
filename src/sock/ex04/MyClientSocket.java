package sock.ex04;

import com.google.gson.Gson;
import sock.ex03.MyDto;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

// 헤더데이터와 프로토콜에 대해
// 헤더데이터 통신에 필요한 데이터
// 바디데이터 : 실제 보낼 내용

public class MyClientSocket {
    BufferedReader br, keyboard;
    PrintWriter pw;
    Socket socket;

    class ReadThread implements Runnable {

        @Override
        public void run() {
            while (true){
                try {
                    String msg=br.readLine();
                    System.out.println("받은 메시지:" + msg);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    public void init(){
        try {
            socket = new Socket("localhost", 10000);

            pw = new PrintWriter(socket.getOutputStream(), true);

            // 입력을 계속 받기 위한 구현
            br = new BufferedReader(new InputStreamReader(socket.getInputStream())); //전이중

            keyboard = new BufferedReader(new InputStreamReader(System.in)); // 반이중

            // 스레드 생성, 읽기 스레든느 일기만 함
            Thread t1 = new Thread(new ReadThread());
            t1.start();

            // 메인 스레드는 쓰기만 함
            while(true){
                String keyboardMsg = br.readLine();
                MyDto dto = new MyDto(1, "성공", keyboardMsg);
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
