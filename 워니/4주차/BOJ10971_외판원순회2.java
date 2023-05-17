import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ10971_외판원순회2 {


    static int[][] cityGraph; // 도시간의 거리 배열
    static boolean[] visited; // 방문한 도시 확인 배열
    static int N; // 도시 수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());

        cityGraph = new int[N][N]; //도시 간의 거리
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cityGraph[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        visited[0] = true;
        int minCost = Integer.MAX_VALUE;

        minCost = tsp(0,1, 0, minCost);

        System.out.println(minCost);
    }

    private static int tsp(int currentCity, int count, int cost, int minCost) {
        if (count == N && cityGraph[currentCity][0] != 0) { // count == n 모든 도시를 방문했을때, cityGraph[currentCity][0] != 0 시작 도시로 돌아가는 간선이 있는 경우
            minCost = Math.min(minCost, cost + cityGraph[currentCity][0]);
            return minCost;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && cityGraph[currentCity][i] != 0) {
                visited[i] = true;
                minCost = tsp(i,count + 1, cost + cityGraph[currentCity][i], minCost);
                visited[i] = false;
            }
        }

        return minCost;
    }
}
