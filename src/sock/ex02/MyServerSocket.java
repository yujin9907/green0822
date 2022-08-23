package sock.ex02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

// 어디에 와일을 돌려야 될지 생각해보기, 연결 세션말고, 새로 연결되는 실제 소켓 통신에 사용되는 곳에 와일이 있어야됨(연결된 상태 유지, 통신 가능한 상태 유지)
// 즉, 소켓(통신을 위한 소켓)이 만들어진 이후부터 while(연결상태유지)이 돌면 됨
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
