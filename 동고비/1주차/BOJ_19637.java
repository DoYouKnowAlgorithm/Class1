import java.util.*;
import java.io.*;

//아직 통과 실패...더이상은 머리가 안돌아가서 투자대비효율이 안나온다...
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        String[] inputNM = br.readLine().split(" ");
        int N = Integer.parseInt(inputNM[0]);
        int M = Integer.parseInt(inputNM[1]);

        TreeMap<Integer,String> map = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            String[] character = br.readLine().split(" ");

            String title = character[0];    //칭호
            int power = Integer.parseInt(character[1]);     //전투력

            map.put(power, title);
        }


        for (int i = 0; i < M; i++) {
            int condition = Integer.parseInt(br.readLine());    //받은 조건

            //해당되는칭호가 없으면 첫번째의 칭호 호출
            String result = map.ceilingEntry(condition) != null ? map.ceilingEntry(condition).getValue() : map.firstEntry().getValue();

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}