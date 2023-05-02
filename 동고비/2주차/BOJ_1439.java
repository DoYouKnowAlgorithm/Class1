import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String input;

    /* 시도1 0의 모임과 1의 모임의 갯수를 각각 세서 적은것들을 뒤집을려함
    *  구현가능했고 통과도 했음 하지만 이게 맞나,,,? 싶음
    *  이런 1차원적인 사고방식은 아름답지 못하다고 느낌 뭔가...뭔가 더 있을거같고 뭔가 더 효율적인게 있을거같다는 간질거림이 생김
    *  하얀님껄 보면서 새로운 시선이 열림
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();

        int count = 0;
        char prev = input.charAt(0);

        //몇개인지는 중요하지 않다 변화가 있는지 없는지만 알면 될뿐!!!!!!!!!!!
        for (int i = 1; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current != prev) {
                count++;
                prev = current;
            }
        }

        //한번 변하는건 한번만 뒤집으면 됨 , 두번 변해도 한번만 뒤집으면 됨 , 세번 변하면 두번 뒤집어야함 ,네번 변해도 두번만 뒤집으면 됨

        /*if(count > 1){
            count /= 2;
          } 이렇게 할려다가

          먼저 +1 해줘도 나눌때 어짜피 정수로 나와서 결과에는 변함이 없다는걸 깨달음
         */
        System.out.println((count + 1) / 2);
    }
}
