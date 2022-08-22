package communication;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// url 만들기
public class GongEx01 {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst?serviceKey=1jqc0MFNwaBew0VSz8GkPRmTWMSfrJ5h%2BtZ8rXStzRQlugp61AKTjGTiaI2qaHTV0mLxPFeDXMVXVSbeXcc1BQ%3D%3D&pageNo=1&numOfRows=1000&dataType=json&base_date=20220822&base_time=1500&nx=55&ny=127");
        // 이걸 버퍼와 연결해서 읽기

        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // HttpsURLConnection으로 하면 전부 다 크롤링함
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            StringBuilder sb = new StringBuilder();

            String temp="";
            while( (temp = br.readLine()) != null ){ // 버퍼 특성상 읽으면 사라지니까 담으면서 실행
                //System.out.println(temp);
                sb.append(temp); // 뿌려서 호출? 뭐 할라고?
            }

            System.out.println(sb.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
