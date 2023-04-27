import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Integer[] expected = new Integer[N]; //입력받은 등수 배열

        for (int i = 0; i < N; i++) {
            expected[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(expected); //정렬

        long sum = 0;
        for (int i = 0; i < N; i++) {
            int diff = Math.abs(expected[i] - (i+1));  //정렬된 배열과 실제등수의 차이를 구한다
            sum += diff;  // 그 차이를 결과값에 더해준다
        }

        System.out.println(sum);
    }
}