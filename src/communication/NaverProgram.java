package communication;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// url 만들기
public class NaverProgram {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://www.naver.com");
        // 이걸 버퍼와 연결해서 읽기

        try {
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            // HttpsURLConnection으로 하면 전부 다 크롤링함
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String temp="";
            while( (temp = br.readLine()) != null ){ // 버퍼 특성상 읽으면 사라지니까 담으면서 실행
                System.out.println(temp);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
