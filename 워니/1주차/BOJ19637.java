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
        int n = Integer.parseInt(stk.nextToken()); // 3
        int m = Integer.parseInt(stk.nextToken()); // 8
        chinghoNames = new String[n];
        combatPowers = new int[n];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            chinghoNames[i] = stk.nextToken();
            combatPowers[i] = Integer.parseInt(stk.nextToken());
        }

        for (int i = 0; i < m; i++) {
            int combatPower = Integer.parseInt(br.readLine());
            int l = 0, r = n - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (combatPowers[mid] < combatPower) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            bw.write(chinghoNames[l] + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}