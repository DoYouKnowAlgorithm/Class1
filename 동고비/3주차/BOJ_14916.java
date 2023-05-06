import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
    * 처음 든 생각 입력값을 일단 5로 나누고 몫에서 1씩 줄여가며  나머지를 2로 나눴을때 떨어지면 두 값의 몫을 더하면 될거같다.
    * 일단 통과 했으니 이제 주제대로 BFS와 DP가 뭔지 왜 이걸 써야하는지 공부해보고 구현도 해보자
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        int fiveWon = input / 5;    //5원 동전의 개수
        int twoWon = 0;     //2원 동전의 개수

        // 5원 동전의 개수를 줄여나가며 2원 동전의 개수를 구한다
        while (fiveWon >= 0) {
            int remainder = input - fiveWon * 5; // 나머지
            if (remainder % 2 == 0) { // 나머지가 2로 나눠진다면
                twoWon = remainder / 2; // 2원의 갯수구해짐
                break;
            }
            fiveWon--;
        }

        if (fiveWon < 0) {
            System.out.println("-1");
        } else {
            System.out.println(fiveWon + twoWon);
        }
    }
}
