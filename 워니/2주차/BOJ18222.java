import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ18222 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String tempS = "";
    static long n;
    public static void main(String[] args) throws IOException {

        n = Long.parseLong(br.readLine());
        String s = "0";

        int cnt = 0;
        int num = 1;
        while (num <= n) { // 2의 제곱중 n보다 크면서 가장 작은 수 (승)
            num *= 2;
            cnt++;
        }
        recursive(cnt, s);
    }

    private static void getAnswer(String tempS, long n) {
        System.out.println(tempS.charAt((int) n));
    }

    /**
     * 제귀 함수
     * @param cnt
     * @param s
     */
    private static void recursive(int cnt, String s) {
        if (cnt == 0) {
            getAnswer(tempS, n);
            return;
        }
        tempS = getNext(s);
        recursive(cnt - 1, tempS);
    }

    /**
     * 실질적인 로직 반복문과 조건문을 통해 매개변수로 들어온 s의 반대되는 transS 를 구해 합친다.
     * @param s
     * @return
     */
    private static String getNext(String s) {
        String transS = "";
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a == '0') {
                transS += "1";
            }else{
                transS += "0";
            }
        }
        return s + transS;
    }
}
