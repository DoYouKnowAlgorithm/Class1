import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;


public class BOJ_19637 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int titleSize = parseInt(st.nextToken());
        int playerSize = parseInt(st.nextToken());

        Map<Integer, String> titles = new LinkedHashMap<>();

        // 칭호 중복 제거해서 입력 받기
        for (int i = 0; i < titleSize; i++) {
            st = new StringTokenizer(br.readLine());
            String titleName = st.nextToken();
            int point = parseInt(st.nextToken());

            if (titles.containsKey(point)) continue;

            titles.put(point, titleName);
        }

        int size = titles.values().size();
        int[] pointList = new int[size];

        int index = 0;
        for (Integer point : titles.keySet()) {
            pointList[index++] = point;
        }

        for (int i = 0; i < playerSize; i++) {
            int playerPoint = parseInt(br.readLine());

            int startIndex = 0;
            int endIndex = size - 1;

            while (startIndex <= endIndex) {
                int moveIndex = (startIndex + endIndex) / 2;
                if (playerPoint > pointList[moveIndex]) startIndex = moveIndex + 1;
                else endIndex = moveIndex - 1;
            }

            bw.write(titles.get(pointList[startIndex]) + "\n");
        }

        close();
    }

    private static void close() throws IOException {
        bw.flush();
        bw.close();
        br.close();
    }

}