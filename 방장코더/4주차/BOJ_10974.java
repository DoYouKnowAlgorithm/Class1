import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon10974 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean[] visited;
    private static int[] result;
    private static final int START_DEPTH = 0;
    private static final int ADD_INDEX = 1;

    public static void main(String[] args) throws IOException {
        int size = inputSize();
        initialize(size);
        backtracking(size, START_DEPTH);
    }

    private static int inputSize() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static void initialize(int size) {
        result = new int[size];
        visited = new boolean[size];
    }

    private static void backtracking(int size, int depth) {
        resultPrint(size, depth);

        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i + ADD_INDEX;
                backtracking(size, depth + ADD_INDEX);
                visited[i] = false;
            }
        }
    }

    private static void resultPrint(int size, int depth) {
        if (size == depth) {
            for (int view : result) {
                System.out.print(view + " ");
            }
            System.out.println();
        }
    }

}
