package except;

public class TryEx03 {

    public static void 나누기(int n1, int n2){
        try {
            System.out.println(n1/n2);
        } catch (Exception e) {
            System.out.println("0을 넣으면 안 됨");
        }
    }
    // 인트의 스칼라가 아닌 벡터를 받는 경우(배열)
    // n은 지역변수, 메서드 변수
    public static void 순회하기(int n[]){
        try {
            for(int i =0;i<3;i++){ // 사실 여길 n.length로 처리하는 게 맞지만 바꿀 수 없다고 가정
                System.out.println(n[i]);
            }
        } catch (Exception e) {
            System.out.println(" 제발 배열 3개 주세요 ");
        }
    }

    public static void main(String[] args) {
        나누기(5,0); // 일부러 런타임 오류
        int[] n = {1,2, 3, 4}; // 일부러 런타임 오류 2 ; 오류가 아니지만 원하는 프로그램이 아님
        순회하기(n);
    }
}
