import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon12869 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int result = Integer.MAX_VALUE;
    private static final int MAX_HP = 61;
    private static final boolean[][][] SCV = new boolean[MAX_HP][MAX_HP][MAX_HP];
    private static final int FIRST_DAMAGE = 9;
    private static final int SECOND_DAMAGE = 3;
    private static final int THIRD_DAMAGE = 1;
    private static final int COUNT = 1;

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] scvHp = new int[3];

        int index = 0;
        while (st.hasMoreTokens()) {
            scvHp[index++] = Integer.parseInt(st.nextToken());
        }

        BFS(scvHp[0], scvHp[1], scvHp[2], 0);
        System.out.println(result);
    }

    private static void BFS(int firstHp, int secondHp, int thirdHp, int attackCount) {
        int[] sort = {firstHp, secondHp, thirdHp};

        Arrays.sort(sort);

        firstHp = Math.max(sort[2], 0);
        secondHp = Math.max(sort[1], 0);
        thirdHp = Math.max(sort[0], 0);

        if (firstHp == 0 && secondHp == 0 && thirdHp == 0) {
            result = Math.min(result, attackCount);
            return;
        }

        if (SCV[firstHp][secondHp][thirdHp]) return;
        else SCV[firstHp][secondHp][thirdHp] = true;

        if (result < attackCount) return;

        BFS(firstHp - FIRST_DAMAGE, secondHp - SECOND_DAMAGE, thirdHp - THIRD_DAMAGE, attackCount + COUNT);
        BFS(firstHp - FIRST_DAMAGE, secondHp - THIRD_DAMAGE, thirdHp - SECOND_DAMAGE, attackCount + COUNT);
        BFS(firstHp - SECOND_DAMAGE, secondHp - FIRST_DAMAGE, thirdHp - THIRD_DAMAGE, attackCount + COUNT);
        BFS(firstHp - SECOND_DAMAGE, secondHp - THIRD_DAMAGE, thirdHp - FIRST_DAMAGE, attackCount + COUNT);
        BFS(firstHp - THIRD_DAMAGE, secondHp - FIRST_DAMAGE, thirdHp - SECOND_DAMAGE, attackCount + COUNT);
        BFS(firstHp - THIRD_DAMAGE, secondHp - SECOND_DAMAGE, thirdHp - FIRST_DAMAGE, attackCount + COUNT);
    }

}
