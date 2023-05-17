import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10974_모든순열 {
    static int n;
    static int[] arr;
    static boolean[] visit;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    static StringTokenizer stk;
    public static void main(String[] args) throws IOException {

        stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());

        arr = new int[n];
        visit = new boolean[n];

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if (depth == n) {
            for (int i : arr) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
}
