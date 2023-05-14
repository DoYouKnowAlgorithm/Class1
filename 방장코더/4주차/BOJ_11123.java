import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon11123 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final String SHEEP = "#";
    private static final String NOT_SHEEP = ".";
    private static final int[] DX = {1, -1, 0, 0};
    private static final int[] DY = {0, 0, 1, -1};
    private static String[][] sheepList;
    private static boolean[][] visited;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        int size = inputSize();

        for (int i = 0; i < size; i++) {
            initialize();
            inputSheepList();
            sheepCount();
            System.out.println(result);
        }

    }

    private static void DFS(int x, int y) {
        visited[x][y] = true;

        if (sheepList[x][y].equals(NOT_SHEEP)) return;

        for (int i = 0; i < 4; i++) {
            int xIndex = x + DX[i];
            int yIndex = y + DY[i];

            if (xIndex >= 0 && xIndex < sheepList.length
                    && yIndex >= 0 && yIndex < sheepList[0].length
                    && sheepList[xIndex][yIndex].equals(SHEEP)
                    && !visited[xIndex][yIndex]) {
                DFS(xIndex, yIndex);
            }
        }

    }

    private static void initialize() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());

        sheepList = new String[row][column];
        visited = new boolean[row][column];
        result = 0;
    }

    private static void inputSheepList() throws IOException {
        for (int i = 0; i < sheepList.length; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                sheepList[i][j] = String.valueOf(input.charAt(j));
            }
        }
    }

    private static void sheepCount() {
        for (int i = 0; i < sheepList.length; i++) {
            for (int j = 0; j < sheepList[i].length; j++) {
                if (!visited[i][j] && sheepList[i][j].equals(SHEEP)) {
                    DFS(i, j);
                    result++;
                }
            }
        }
    }

    private static int inputSize() throws IOException {
        return Integer.parseInt(br.readLine());
    }

}
