import java.io.*;
import java.util.StringTokenizer;

public class BOJ11931 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    public static void main(String[] args) throws IOException {

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            stk = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        divide(arr, 0, arr.length - 1);
        print(arr);
    }

    private static void print(int[] arr) throws IOException {
        for (int i = 0; i < arr.length; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
    }

    public static void divide(int[] arr, int left, int right) {
        if (left < right) {

            int middle = (left + right) / 2;

            divide(arr,left, middle); //왼쪽분할
            divide(arr, middle + 1, right); //오른쪽분할
            reverseConquer(arr, left, middle, right); //정복
        }
    }

    private static void conquer(int[] arr, int left, int middle, int right) { //오름차순
        int i = left;
        int j = middle + 1;
        int k = left;

        int[] sorted = new int[arr.length];

        while (i <= middle && j <= right) {
            if (arr[i] < arr[j]) {
                sorted[k] = arr[i];
                k++;
                i++;
            }else{
                sorted[k] = arr[j];
                k++;
                i++;
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


    private static void reverseConquer(int[] arr, int left, int middle, int right) { // 내림차순
        int i = left;
        int j = middle + 1;
        int k = left;

        int[] sorted = new int[arr.length];

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
