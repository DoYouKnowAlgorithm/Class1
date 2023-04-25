package Algorithm.BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class _19637 {
    static BufferedReader br = getBufferedReader();
    static BufferedWriter bw = getBufferedWriter();
    static String[] titles;
    static int[] values;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = getTokenizer();
        int n = getIntFromToken(st);
        int m = getIntFromToken(st);

        initTable(n);
        solution(n, m);
    }

    private static void initTable(int n) throws IOException {
        titles = new String[n];
        values = new int[n];

        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st = getTokenizer();
            titles[i] = getStringFromToken(st);;
            values[i] = getIntFromToken(st);
        }
    }

    private static void solution(int n, int m) throws IOException {
        for (int i = 0; i < m; i++) {
            int input = getIntFromInput();
            String title = binarySearch(0, n - 1, input);
            bw.write(title + "\n");
        }
        bw.flush();
    }

    private static String binarySearch(int start, int end, int target) {
        int middle;

        while (start <= end) {
            middle = (start + end) / 2;
            if (target > values[middle]) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        return titles[start];
    }

    private static int getIntFromInput() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static int getIntFromToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    private static String getStringFromToken(StringTokenizer st) {
        return st.nextToken();
    }

    private static StringTokenizer getTokenizer() throws IOException {
        return new StringTokenizer(br.readLine());
    }

    private static BufferedReader getBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    private static BufferedWriter getBufferedWriter() {
        return new BufferedWriter(new OutputStreamWriter(System.out));
    }
}
