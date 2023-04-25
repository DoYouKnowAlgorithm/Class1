package Algorithm.BOJ;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _19637 {
    static BufferedReader br = getBufferedReader();
    static BufferedWriter bw = getBufferedWriter();
    static HashMap<Integer, String> table = new HashMap<>();
    static Integer[] keys;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = getTokenizer();
        int n = getTokenAsInt(st);
        int m = getTokenAsInt(st);

        initSetup(n);
        solution(n, m);
    }

    private static void initSetup(int n) throws IOException {
        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st = getTokenizer();
            String value = getToken(st);
            Integer key = getTokenAsInt(st);

            if (isNotDuplicated(key)) {
                table.put(key, value);
            }
        }

        keys = table.keySet().toArray(new Integer[0]);
    }

    private static void solution(int n, int m) throws IOException {
        for (int i = 0; i < m; i++) {
            int input = readInputAsInt();
            String title = binarySearch(input);
            print(title);
        }
    }

    private static String binarySearch(int target) {
        int start = 0;
        int end = keys.length - 1;
        int middle;

        while (start <= end) {
            middle = (start + end) / 2;
            if (target > keys[middle]) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        return getTitle(keys[start]);
    }

    private static String getTitle(Integer key) {
        return table.get(key);
    }

    private static boolean isNotDuplicated(Integer key) {
        return !table.containsKey(key);
    }

    private static int readInputAsInt() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static int getTokenAsInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    private static String getToken(StringTokenizer st) {
        return st.nextToken();
    }

    private static void print(String title) throws IOException {
        bw.write(title + "\n");
        bw.flush();
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
