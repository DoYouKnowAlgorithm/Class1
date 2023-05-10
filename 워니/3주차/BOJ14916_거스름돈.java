package BFS_DP;

import java.util.Scanner;

public class BOJ14916_거스름돈 {
    static Scanner scanner;

    static int[] dp;
    static int change;
    static final int maxValue = Integer.MAX_VALUE;
    public static void main(String[] args) {

        input();
        init();
        fillDpLogic();
        print();
    }

    private static void print() {
        int answer = dp[change] == maxValue ? -1 : dp[change];
        System.out.println(answer);
    }

    private static void fillDpLogic() {
        for (int i = 6; i <= change; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 5]) + 1;
        }
    }

    private static void init() {
        dp = new int[100001]; //첫째 줄에 거스름돈 액수 n(1 ≤ n ≤ 100,000)이 주어진다.
        for (int i = 0; i < dp.length; i++) {
            dp[i] = maxValue;
        }

        dp[2] = 1;
        dp[4] = 2;
        dp[5] = 1;
    }

    private static void input() {
        scanner = new Scanner(System.in);
        change = scanner.nextInt();
    }
}
