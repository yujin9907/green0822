package sock.ex03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerSocket {

    ServerSocket serverSocket;

    public void init(){
        System.out.println("서버 시작-----------");
        try {
            serverSocket = new ServerSocket(10000);
            Socket socket = serverSocket.accept();

            System.out.println("클라이언트 연결됨....");

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println("받은 메시지... ");

            // 이런식으로 수정; 브레이크 포인트(문자)를 바꿔주기 => 일종의 프로토콜이라고 생각하고 예시
            while(true){
                String msg = br.readLine();
                System.out.println("받은 메시지 : "+msg);

                if(msg.equals("bye")){
                    break;
                }
            }
            System.out.println("서버 종료");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyServerSocket ms = new MyServerSocket();
        ms.init();
    }
}
