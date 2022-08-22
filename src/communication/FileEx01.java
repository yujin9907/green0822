package communication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// 파일을 입출력하는 법
public class FileEx01 {
    File file = new File("d:\\data.txt"); // 메모리에 data.txt를 만듦
    // 자바의 역슬래쉬는 이스캐이프 문법이라서 두개 해야 됨
    // 운영체제마다 적어주는 게 다른데 나중에 리눅스 때 알려준대
    FileReader fr;
    {
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
