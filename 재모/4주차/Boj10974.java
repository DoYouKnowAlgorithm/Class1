import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj10974 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static boolean[] visited;
    private static int[] num;
    private static int START_DEPTH = 0;

    public static void main(String[] args) throws IOException {
        initialize();
        bt(START_DEPTH, visited, num);
    }

    public static void bt(int depth, boolean[] visited, int[] num) {
        if (depth == N) {
            printNum();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                num[depth] = i;
                bt(depth + 1, visited, num);
                visited[i] = false;
            }
        }
    }

    private static void initialize() throws IOException {
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        num = new int[N];
    }

    public static void printNum() {
        for (int i = 0; i < N; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println();
    }
}
