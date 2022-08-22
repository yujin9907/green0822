package communication;

import com.google.gson.Gson;
import communication.respDto.RespDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// gson 받고 처리하기
public class GongEx02 {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst?serviceKey=1jqc0MFNwaBew0VSz8GkPRmTWMSfrJ5h%2BtZ8rXStzRQlugp61AKTjGTiaI2qaHTV0mLxPFeDXMVXVSbeXcc1BQ%3D%3D&pageNo=1&numOfRows=1000&dataType=json&base_date=20220822&base_time=1500&nx=55&ny=127");

        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            StringBuilder sb = new StringBuilder();

            String temp="";
            while( (temp = br.readLine()) != null ){ // 버퍼 특성상 읽으면 사라지니까 담으면서 실행
                sb.append(temp);
            }

            // json(String) 을 RespDto로 변환
            Gson gson = new Gson();
            // 메서드 두개 있음 : JSON을 오브젝트로, 자바객체를 JSON으로
            // gson.toJson(); 자바오브젝트를 제이슨으로
            RespDto respDto = gson.fromJson(sb.toString(), RespDto.class);

            // 원하는 값 찾기
            String temperature = respDto.getResponse().getBody().getItems().getItem().get(3).getBaseDate();
            System.out.println(temperature);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
