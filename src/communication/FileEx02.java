package communication;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileEx02 {
    public static void main(String[] args) {
        // 파일 쓰기 : 날짜별 매일 로그를 남기는 시스템 만들기
        File fileWrite = new File("D:\\data2.txt");
        // 이런 것도 있음
        if(!fileWrite.exists()){
            try {
                fileWrite.createNewFile(); // 없으면 신규생성하라고
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                FileWriter fw = new FileWriter(fileWrite, true);
                BufferedWriter bw = new BufferedWriter(fw);

                bw.write("쓰기\n");
                bw.flush();
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
