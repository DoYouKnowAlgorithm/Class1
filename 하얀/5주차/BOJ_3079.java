import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3079 {
    private static int n;
    private static long cntPerson;
    private static long[] time;
    private static long MAX_VALUE;
    private static long answer;

    public static void main(String[] args) throws IOException {
        input();
        findMinTime();
        output();
    }

    private static void output() {
        System.out.println(answer);
    }

    private static void findMinTime() {
        long low = 0;
        long high = MAX_VALUE;

        while (low <= high) {
            long mid = (low + high) / 2;

            long totalPerson = 0;
            for (int i = 0; i < n; i++) {
                long cur = mid / time[i];

                if (totalPerson >= cntPerson || time[i] > mid) break;

                totalPerson += cur;
            }

            if (totalPerson >= cntPerson) {
                high = mid - 1;
                answer = Math.min(answer, mid);
            } else {
                low = mid + 1;
            }
        }


    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        cntPerson = Long.parseLong(st.nextToken());

        time = new long[n];

        long max = 0;
        for (int i = 0; i < n; i++) {
            time[i] = Long.parseLong(br.readLine());
            max = Math.max(max, time[i]);
        }

        MAX_VALUE = cntPerson * max;
        answer = MAX_VALUE;
        Arrays.sort(time);
    }
}
