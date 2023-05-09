import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long [][] dp = new long[n+1][m+1];

        dp[1][1] =1;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(i==1 && j==1) continue;
                dp[i][j]=(dp[i][j-1]+dp[i-1][j]+dp[i-1][j-1])%1000000007;
            }
        }
        System.out.print(dp[n][m]);
    }
}
//세상에서 가장 부끄러운 정답
//다른 사람껄 안보고선 난 저 점화식을 도출해 내지 못했을것이다.