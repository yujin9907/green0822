package sock.ex02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

// 이새낀 이제 쓰기를 반복하면 됨

public class MyClientSocket {

    Socket socket;
    public void init(){
        try {
            socket = new Socket("192.168.0.125", 10000);

            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

            // 입력을 계속 받기 위한 구현
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while(true){
                String keyboardMsg = br.readLine(); // 키보드 엔터를 누를 때까지
                pw.println(keyboardMsg);
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
