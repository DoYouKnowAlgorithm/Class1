import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14916 {
    static int money;
    static int[] coin;
    public static void main(String[] args) throws IOException {
        input();
        fillCoin();
        output();
    }

    private static void output() {
        System.out.println(coin[money]);
    }

    private static void fillCoin() {
        for (int i = 6; i <= money; i++) {
            if (coin[i - 2] == -1) {
                coin[i] = coin[i - 5] + 1;
            } else if (coin[i - 5] == -1) {
                coin[i] = coin[i - 2] + 1;
            } else {
                coin[i] = Math.min(coin[i - 2], coin[i - 5]) + 1;
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        money = Integer.parseInt(br.readLine());
        // money + 1 크기만 생성하면 n이 5보다 작은 경우
        // 점화식의 초기값을 일일히 조건에 따라 넣어줘야 하기 때문에
        // 애초에 money + 5 크기로 생성했다.
        coin = new int[money + 5];
        coin[1] = -1;
        coin[2] = 1;
        coin[3] = -1;
        coin[4] = 2;
        coin[5] = 1;
    }
}
