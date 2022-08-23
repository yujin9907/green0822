package sock.th;

// 소켓

interface Game{
    // 메서드 사용하려면 클래스를 만들 수밖에 없음
    // 인터페이스에선 추상메서드 정의 -> 강제성 부여(복습)

    void start();
}

class MyGame implements Game{
    // 오버라이딩하라고 오류 뜨면서 자동 구현
    @Override
    public void start() {
        System.out.println("게임 시작");
    }
}

public class ThEx01 {
    public void run(Game game){ // 게임타입을 가지고 있네?
        game.start();
        // 즉, game 인터페이스를 사용한 이유는, 사실 매개변수로 함수를 넣고 싶었던 거임.
        // 근데 자바는 메서드 타입이 없음=1급객체가 클래스
        // 그래서 인터페이스를 구현해서 넘기는 거임(인터페이스를 경유해서 넘겼다고 보면 됨)
        // 정리, 메서드를 전달하는 방법(인터페이스를 통한 구현)
    }

    public static void main(String[] args) {
        // 런을 실행시켜라 라는 미션
        ThEx01 th = new ThEx01(); // 당연히 일단 객체를 먼저 생성해줘야됨 사용하려면
        th.run(new MyGame()); // 런을 썼는데, 게임 타입이 필요하네... run에가서 확인하니까 게임 인터페이스가 있음 -> 무조건
        // 인터페이스는 구현할 수 없음으로 MY를 만들어서 NEW 해줌
    }
}
