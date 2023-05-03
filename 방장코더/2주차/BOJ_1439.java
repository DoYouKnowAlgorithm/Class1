import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.*;

public class BaekJoon1439 {
    private static String ZERO = "0";
    private static String ONE = "1";

    public static void main(String[] args) throws IOException {
        solution();
    }

    private static void solution() throws IOException {
        int result = checkWord(input());
        resultPrint(result);
    }

    private static String input() throws IOException {
        return new BufferedReader(new InputStreamReader(in)).readLine();
    }

    private static int checkWord(String input) {
        int zeroCount = checkNumberCount(input, ZERO, ONE);
        int oneCount = checkNumberCount(input, ONE, ZERO);

        return Math.min(zeroCount, oneCount);
    }

    private static int checkNumberCount(String input, String target, String regex) {
        int count = 0;
        String[] inputSplit = input.split(regex);

        for (int i = 0; i < inputSplit.length; i++) {
            if (inputSplit[i].contains(target)) count++;
        }
        return count;
    }

    private static void resultPrint(int result) {
        out.println(result);
    }

}