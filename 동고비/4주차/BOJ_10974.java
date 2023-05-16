import java.io.*;

public class Main {
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        boolean[] isVisited = new boolean[N + 1];  // 숫자 사용 여부를 확인하는 배열
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        dfs(0, isVisited, new int[N], bw);
        bw.flush();
        bw.close();
    }

    /**
     * @param depth     재귀의 깊이 : 지금까지 몇개 선택했는지
     * @param isVisited 사용되었는지 판단 하는 불리안 : 사용된건 true
     * @param nums      인덱스는 깊이, 값은 선택한 숫자
     * @param bw        적어라
     */
    private static void dfs(int depth, boolean[] isVisited, int[] nums, BufferedWriter bw) throws IOException {
        if (depth == N) { // 모든 숫자를 사용한 경우
            for (int num : nums) { // 모든 숫자를 출력
                bw.write(num + " ");
            }
            bw.newLine();
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!isVisited[i]) { // 사용하지 않은 숫자인 경우
                isVisited[i] = true; // 숫자 사용 처리
                nums[depth] = i; // 현재 depth 위치에 숫자 저장
                dfs(depth + 1, isVisited, nums, bw); // 다음 depth 탐색
                isVisited[i] = false; // 탐색이 끝나면 사용 여부 반환
            }
        }
    }
}