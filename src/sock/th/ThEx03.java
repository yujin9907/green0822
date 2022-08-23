package sock.th;

// 비동기 프로그램 이해를 위한 스레드 : 스레드 만들기 (아주 중요한 개념)

// 구분하고 헷갈리지 말아야 할 '동기'의 개념
// 동기적-데이터 = 동기화는 두 개가 같은 데이터임을 의미함, 일관성을 유지되야 함, 데이터의 일치를 의미함
// 동기적-프로그램 = 일의 순서가 있다는 말, 동기적 실행

// 비동기 프로그램 : 일의 순서가 없음

// 당연히 메타데이터를 고려해서 비동기 프로그램을 작성해야 되는데, 이러면 코드가 엄청 복잡해짐, 좋은 코드가 될 수 없음
// 그럼에도 비동기적 프로그램을 만들어야 될 상황이 있다.

// nio(논블럭 io)
// 단일스레드로 처리, 여러스레드 방식이 있음
// 근데 단일 스레드로 처리하는 게 더 좋음

class FakeThread{
    public void run(){
        for(int i=1;i<11;i++){
            System.out.println("뉴스레드 "+i);
            try {
                Thread.sleep(1000); // 1/1000초 ; 밀리세컨드로, 1000 을 입력하면 1초
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
// Thread 안에 넣을 타입 runnable이기 때문에 생성
class RealThread implements Runnable {

    @Override
    public void run() {

        for (int i = 1; i < 11; i++) {
            System.out.println("메인스레드 " + i);
            try {
                Thread.sleep(1000); // 1/1000초 ; 밀리세컨드로, 1000 을 입력하면 1초
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

    public class ThEx03 {
        public static void main(String[] args) {
            FakeThread ft = new FakeThread();
            ft.run();

            //진짜 스레드
            Thread t1 = new Thread(new RealThread()); // 타겟값 : 러너블 타입만 받음, 스레드마다 타겟이 다름
            t1.start();

            for (int i = 1; i < 11; i++) {
                System.out.println("메인스레드 " + i);
                try {
                    Thread.sleep(1000); // 1/1000초 ; 밀리세컨드로, 1000 을 입력하면 1초
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

