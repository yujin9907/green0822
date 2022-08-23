package sock.ex01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class MyClientSocket {

    Socket socket;
    public void init(){
        try {
            socket = new Socket("localhost", 10000);

            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            pw.println("hello");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyClientSocket ms = new MyClientSocket();
        ms.init();
    }
}
