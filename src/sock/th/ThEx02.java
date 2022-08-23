package sock.th;

// 행위를 넘겨주는 게 목적

interface Game2{
    void start();
}

public class ThEx02 {
    public void run(Game2 game){
        game.start();
    }

    public static void main(String[] args) {
        ThEx02 th = new ThEx02();

        // 클래스를 구현하지 않고 이렇게도 만들 수 있음
        th.run(new Game2() {
            @Override
            public void start() {

            }
        });


//        new Game2() {
//            @Override
//            public void start() {
//                // new가 된 게 누구임? 저 인터페이스game2를 구현한 게 아니라(인터페이스는 구현이 안 됨)
//                // 이런 메서드를 담고 있는 새로운 객체를 구현한 거임
//            }
//        }
        // 이걸 만들고 싶었던 거임 원래는 근데 자바에선 안 되니까
//        Game2 game2 = (){
//
//        }
        Game2 game3 = () ->{
            // 익명 클래스의 핵심은 '메서드를 넘겨주고 싶음' 이다
            // 그래서 자바 8인가 어디부터 익명함수
        };
    }
}
