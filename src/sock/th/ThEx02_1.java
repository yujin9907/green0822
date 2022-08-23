package sock.th;

// 행위를 넘겨주는 게 목적

interface Game5{
    String start();
}

public class ThEx02_1 {
    public void run(Game5 game){
        game.start();
    }

    public static void main(String[] args) {
        ThEx02_1 th = new ThEx02_1();

        // 클래스를 구현하지 않고 이렇게도 만들 수 있음
        th.run(new Game5() {
            @Override
            public String start(){
                return null;
            }
        });

        Game5 game3 = () ->{return "";};
    }
}
