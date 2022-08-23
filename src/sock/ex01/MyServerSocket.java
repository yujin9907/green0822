package sock.ex01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerSocket {

    ServerSocket serverSocket;
    // 전역으로 관리하기 위해서 얘를 이용해 통신할 거임


    //os가 들고 있는 소켓 함수(네이티브 함수)를 빌려쓰기 -> oscall이라고 함
    //소켓이라는 틀? 공간? 을 만듦
    // 리스너를 통해 10000(포트번호)의 요청이 들어오면 소켓이 뭐 됨
    public void init(){
        System.out.println("서버 시작-----------");
        try {
            serverSocket = new ServerSocket(10000);
            // 서버 소켓의 대기, 지금 이 코드는 와일이 없으니까 한 번 연결되고 나면 끝남
            Socket socket = serverSocket.accept(); // while 돌면서 리스닝하는 것. 소켓을 리턴해서 소켓 변수로 받아줌
            // 서버소켓-클라이언트; 커넥션되면 세션이 만들어짐, 그러면 '소켓이라는' 스트림을 만들고 기존에 연결된 세션을 끊음 그럼 다른 소켓과 연결될 수 있음
            // 즉, 서버소켓은 초기 연결 세션을 생성하고 다른 클라이언트를 받기 위해서 비워져야 하므로 = 연결을 위한 소켓(10000, 연결을 하고 스트림으로 넘기면 끊어짐)
            // 소켓이라는 새로운 스트림을 만들어서 찐 통신은 이걸로 하는 거 = 통신을 위한 스트림 소켓(렌덤으로 새로운 포트 부여)
            // 즉, socket은 타겟이 되는 거임
            System.out.println("클라이언트 연결됨....");

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println("받은 메시지... ");
            System.out.println(br.readLine());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyServerSocket ms = new MyServerSocket();
        ms.init();
    }
}
