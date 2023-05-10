import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ24444_알고리즘수업_너비우선탐색1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stk;
    static Queue<Integer> queueBfs = new LinkedList<>();
    static List<List<Integer>> graph = new ArrayList<>();
    static Boolean[] visited;
    static int[] result;
    static int node; //정점 개수
    static int line; // 간선 개수
    static int start; // 시작 노드 번호
    public static void main(String[] args) throws IOException {
        input();
        assignLine();
        bfs();
        print();
    }

    private static void print() {
        for (int i = 1; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static void bfs() {
        int cnt = 0;
        queueBfs.offer(start);
        visited[start] = true;

        while (!queueBfs.isEmpty()) {
            int nowNode = queueBfs.poll();
            cnt++;
            result[nowNode] = cnt;
            for (int i = 0; i < graph.get(nowNode).size(); i++) {
                int nextNode = graph.get(nowNode).get(i);
                if (!visited[nextNode]) {
                    queueBfs.offer(nextNode);
                    visited[nextNode] = true;
                }
            }
        }
    }

    private static void assignLine() throws IOException {

        for (int i = 0; i < line; i++) {
            stk = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(stk.nextToken());
            int endNode = Integer.parseInt(stk.nextToken());
            graph.get(startNode).add(endNode);
            graph.get(endNode).add(startNode);
        }

        for (List<Integer> list : graph) {
            Collections.sort(list);
        }
    }

    private static void input() throws IOException {
        stk = new StringTokenizer(br.readLine());
        node = Integer.parseInt(stk.nextToken());
        line = Integer.parseInt(stk.nextToken());
        start = Integer.parseInt(stk.nextToken());
        visited = new Boolean[node + 1];
        result = new int[node + 1];
        Arrays.fill(visited, false);

        //1번 노드 부터 시작되므로 0번째 List는 비워줌
        for (int i = 0; i < node+1; i++) {
            graph.add(new ArrayList<>());
        }
    }
}
