import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ24460 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        StringTokenizer stk;
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int answer = recursive(0, 0, n);
        System.out.println(answer);
    }


//    15 7 13 5
//    4 2 1 9
//    0 10 8 12
//    3 11 14 6

    private static int recursive(int X, int Y, int n) {

        if (n == 1) {
            return arr[X][Y];
        }

        int newN = n / 2;
        int[] result = new int[4];
        result[0] = recursive(X, Y, newN); // 15
        result[1] = recursive(X, Y + newN, newN);
        result[2] = recursive(X + newN, Y, newN);
        result[3] = recursive(X + newN, Y + newN, newN);
        Arrays.sort(result);
        return result[1];
    }
}
