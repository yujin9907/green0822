package communication.respDto;
// 이제 공공데이터로부터 받아온 json 데이터를 뭐 해주려는 듯..?

public class RespDto {
    // {"response":{"header":{"resultCode":"00","resultMsg":"NORMAL_SERVICE"},"body":{"dataType":"JSON","items":{"item":[{"baseDate":"20220822","baseTime":"1530","category":"LGT","fcstDate":"20220822","fcstTime":"1600","fcstValue":"0","nx":55,"ny":127},
    // 생긴 건 json, 자바입장에선 어찌됐건 문자. 이걸이제 표현해줘야 됨
    // private String response; // {"response": 미지수가 문자라면}

    // 1. 타입을 아직 모름
    // {} 기준으로 클래스와 그 안에 내부 변수를 만들어주면 됨
    // 근데 안에 요소를 너무 많이 가져서 타입을 모르곘으면 새로운 클래스를 빼줌
    // 그거에 반복

    // 내부클래스하려다 포기
//    class Response{
//        private Header header;
//        private Body body;
//    }


// 같은 파일에서 public class는 하나밖에 선언하지 못함.
// 라이브러리가 class에 접근하려면...?
// 그래서 내부 클래스 사용 그냥 퍼블릭 안에 넣으면 됨
// 그럼 이 클래스 내부에서 선언된 클래스는 메모리에 뜰까?

// 결국 다 따로 생성함 시발

    private Response response;

    public RespDto() {
    }

    public RespDto(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}