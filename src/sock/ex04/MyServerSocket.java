package sock.ex04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerSocket {

    ServerSocket serverSocket;
    BufferedReader br, keyboard;
    BufferedWriter bw;

    class ReadThred implements Runnable{

        @Override
        public void run() {
            try {
                while(true){
                    String msg = br.readLine();
                    System.out.println("받은 메시지 : "+msg);

                    if (msg.equals("bye")){
                        break;
                    }
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void init(){
        System.out.println("서버 시작-----------");
        try {
            serverSocket = new ServerSocket(10000);
            Socket socket = serverSocket.accept();

            System.out.println("클라이언트 연결됨....");

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            keyboard = new BufferedReader(new InputStreamReader(System.in));


            // 새로운 스레드는 메시지를 읽기만 함
            Thread t1 = new Thread(new ReadThred());
            t1.start();

            // 메인 스레드는 메시지를 전송만 함
            while (true){
                String keyboardMsg = keyboard.readLine();
                bw.write(keyboardMsg+"\n");
                bw.flush();
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyServerSocket ms = new MyServerSocket();
        ms.init();
    }
}
