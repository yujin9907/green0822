package sock.th;

// 행위를 넘겨주는 게 목적

interface Game6{
    String start();
}
class a implements Game6{

    @Override
    public String start() {
        return null;
    }
}

public class ThEx02_2 {
    public void run(Game6 game){
        game.start();
    }

    public static void main(String[] args) {
        ThEx02_2 th = new ThEx02_2();
        th.run(new a());
    }
}
