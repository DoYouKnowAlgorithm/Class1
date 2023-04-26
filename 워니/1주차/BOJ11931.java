import java.io.*;

public class BOJ11931 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static int[] sorted;
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        sorted = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        divide(0, arr.length - 1);
        print();
    }

    private static void print() throws IOException {
        for (int i = 0; i < arr.length; i++) {
            bw.write(arr[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void divide(int left, int right) {
        if (left < right) {

            int middle = (left + right) / 2;

            divide(left, middle); //왼쪽분할
            divide(middle + 1, right); //오른쪽분할
            reverseConquer(left, middle, right); //정복
        }
    }

    private static void reverseConquer(int left, int middle, int right) { // 내림차순
        int i = left;
        int j = middle + 1;
        int k = left;

        while (i <= middle && j <= right) {
            if (arr[i] > arr[j]) {
                sorted[k] = arr[i];
                k++;
                i++;
            }else{
                sorted[k] = arr[j];
                k++;
                j++;
            }
        }

        while (i <= middle) {
            sorted[k] = arr[i];
            k++;
            i++;
        }

        while (j <= right) {
            sorted[k] = arr[j];
            k++;
            j++;
        }

        for (int l = left; l <= right; l++) {
            arr[l] = sorted[l];
        }
    }
}