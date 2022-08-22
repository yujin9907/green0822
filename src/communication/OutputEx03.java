package communication;

import java.io.*;

public class OutputEx03 {
    public static void main(String[] args) {
        // 앞서 배운 01 02 불편 => 버퍼를 사용함
        // NOTION에 정리, 노트에 정리
        // 나머지 실습 꼭 해야 됨


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = null;
        try {
            s = br.readLine();
            System.out.println(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // system.out : 모니터에 연결해주겟다
            bw.write("안녕");
            bw.flush();
        } catch (Exception e){
            e.printStackTrace();
        }

        // 개념 + 사용법 : 버퍼 개념을 확실하게
        // 핵심:system.in = 키보드 연결, system.out = 모니터연결
        // 리더-리드라인, 라이터-라이드-플러시
        // 근데 db와 연결하려면, OutputStreamWrite(연결)에 뭘 적어야 함? 그래서 jdbc를 배운 거
        // 연결 객체가 뭔지 알아야 됨 => 소켓을 배워야 목적지를 만들 수 있음. 이해?
    }
}
