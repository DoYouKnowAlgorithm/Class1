package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3079 {
    static int n;
    static long m;
    static int[] arr;
    static long MAX_VALUE;
    static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 입국심사대 수
        m = Long.parseLong(st.nextToken()); // 사람 수

        arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        MAX_VALUE = m * max; //최대로 걸리는 시간 = 사람 수(m) * 가장 오래 걸리는 심사 시간
        result = MAX_VALUE;
        Arrays.sort(arr); //이분탐색을 위해 정렬

        searchMinTime();
        System.out.println(result);
    }

    // 시간을 기준으로 이분탐색을 한다.
    private static void searchMinTime() {
        long lo = 0;
        long hi = MAX_VALUE;

        while (lo <= hi) {
            long mid = (lo + hi) / 2;

            long totalPerson = 0; // 해당 시간에 각 심사대에서 맡는 사람 수의 합
            for (int i : arr) {
                // 해당 시간에 각 심사대에서 맡을 수 있는 사람 수
                long cntPerson = mid / i;

                // 정렬된 배열이기 때문에 현재 심사대의 심사 시간이 검사 중인 시간보다 크거나
                // 현재까지 사람 수의 합이 총 사람 수보다 크면 바로 반복문을 탈출한다.
                if (totalPerson >= m || i > mid) {
                    break;
                }

                totalPerson += cntPerson;
            }

            // totalPerson 값이 총 사람 수보다 크거나 같다면
            // 더 짧은 시간에 완료될 수 있다는 것을 의미한다.
            // 따라서 hi 값을 mid - 1로 설정한다.
            // 반대로 총 사람 수보다 작다면 해당 시간에 심사가 불가능하다는 것을 의미한다.
            if (totalPerson >= m) {
                hi = mid - 1;
                result = Math.min(result, mid);
            } else {
                lo = mid + 1;
            }
        }
    }
}
