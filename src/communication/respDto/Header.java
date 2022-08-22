package communication.respDto;

// 4. 얘네도 모르니까 또 타입 만들어줌
public class Header {
    private String resultCode;
    private String resultMsg; // 오타 위험 많으니까 되도록 복붙

    public Header() {
    }

    public Header(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}
