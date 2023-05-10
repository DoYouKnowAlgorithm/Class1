import java.util.Scanner;

/**
 * 개어렵다 솔직히
 * 땀나네?
 */
public class BOJ14494_다이나믹이뭐에요 {

    static long dp[][];
    static int low;
    static int column;

    public static void main(String[] args) {
        input();
        initDp();
        System.out.println(dp(low, column));
    }

    private static long dp(int low, int column) {

        if(low == 0 || column == 0) return 0;
        if(low == 1 && column == 1) return 1;
        if(dp[low][column] != -1) return dp[low][column];

        long result = (dp(low, column-1) + dp(low-1, column) + dp(low-1, column-1))%1000000007;
        dp[low][column] = result;
        return result;
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        low = sc.nextInt();
        column = sc.nextInt();
    }

    private static void initDp() {
        dp = new long[low + 1][column + 1];
        for (int i = 0; i <= low; i++) {
            for (int j = 0; j <= column; j++) {
                dp[i][j] = -1;
            }
        }
    }
}
