package sock.ex03;

public class MyDto {

    private int code; // 1 통신성공 -1 실패
    private String msg; // 통신이 어떻게 됐는지 설명
    private String data; // 실제 데이터를 담자

    public MyDto() {

    }

    public MyDto(int code, String msg, String data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}