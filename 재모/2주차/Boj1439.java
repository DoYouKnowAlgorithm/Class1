import java.io.*;

public class Boj1439 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String s = br.readLine();

        int countZero = 0;
        int countOne = 0;

        if (s.charAt(0) == '0') {
            countZero++;
        } else {
            countOne++;
        }

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                if (s.charAt(i) == '0') {
                    countZero++;
                } else {
                    countOne++;
                }
            }
        }

        bw.write(String.valueOf(Math.min(countZero, countOne)));
        bw.flush();
        bw.close();
    }
}
