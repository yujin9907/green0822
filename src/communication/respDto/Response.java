package communication.respDto;

public class Response {
    // 2. 같은 이름의 클래스 생성 (: 클래스는 다른 파일로 빼도 됨)
    // 3. 리스폰스 안 두개, 헤더와 바디
    private Header header;
    private Body body;

    public Response(Header header, Body body) {
        this.header = header;
        this.body = body;
    }

    public Response() {
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}
