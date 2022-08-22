package communication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// 상대 경로, 읽기는 그냥 이제 저렇게 하면 됨
// 문제는 경로가... 절대경로 잘 안씀
// ./ 현재경로
// ../ 바로 위폴더
// / 최상위 폴더
// 자바최상위경로

public class FileEX04 {
    public static void main(String[] args) {
        File file = new File("/data.txt");
        FileReader fr;
        try {
            fr = new FileReader(file);
            // System.out.println(fr.read());
            BufferedReader br = new BufferedReader(fr);

            System.out.println(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
