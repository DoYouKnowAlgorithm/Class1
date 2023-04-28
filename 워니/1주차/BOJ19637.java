import java.io.*;
import java.util.StringTokenizer;

public class BOJ19637 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer stk;

    static String[] chinghoNames;

    static int[] combatPowers;
    public static void main(String[] args) throws IOException {

        stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        chinghoNames = new String[n];
        combatPowers = new int[n];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            chinghoNames[i] = stk.nextToken();
            combatPowers[i] = Integer.parseInt(stk.nextToken());
        }

        for (int i = 0; i < m; i++) {
            int combatPower = Integer.parseInt(br.readLine());
            int left = 0, right = n - 1;
            left = binarySearch(combatPower, left, right);
            bw.write(chinghoNames[left] + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static int binarySearch(int combatPower, int left, int right) {
        while (left <= right) {
            int middle = (left + right) / 2;
            if (combatPowers[middle] < combatPower) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }
}