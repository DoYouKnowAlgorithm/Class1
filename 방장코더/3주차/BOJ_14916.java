package DYKA.세번째;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon14916 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] DP;
    private static int MIN_SIZE = 11;
    private static int SUB_NUMBER = 5;
    private static int ADD_NUMBER = 1;
    private static int START_INDEX = 11;

    public static void main(String[] args) throws IOException {
        solution();
    }

    private static void solution() throws IOException {
        int size = inputSize();
        makeMemoization(size);
        resultPrint(size);
    }

    private static void resultPrint(int size) {
        System.out.println(DP[size]);
    }

    private static void makeMemoization(int size) {
        DP = new int[(int) Math.max(MIN_SIZE, (size + ADD_NUMBER))];

        initialDP();

        for (int i = START_INDEX; i <= size; i++) {
            DP[i] = DP[i - SUB_NUMBER] + ADD_NUMBER;
        }

    }

    private static void initialDP() {
        DP[0] = -1;
        DP[1] = -1;
        DP[2] = 1;
        DP[3] = -1;
        DP[4] = 2;
        DP[5] = 1;
        DP[6] = 3;
        DP[7] = 2;
        DP[8] = 4;
        DP[9] = 3;
        DP[10] = 2;
    }

    private static int inputSize() throws IOException {
        return Integer.parseInt(br.readLine());
    }

}
