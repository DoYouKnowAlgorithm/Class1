import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Boj11931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder()); // 오름차순 정렬

        for (Integer integer : arr) {
            bw.write(integer + "\n");
        }

        bw.flush();
        bw.close();
    }

    /* 왜 안되는걸까..............
    static void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    // 퀵 정렬
    static void quickSort(int[] arr, int left, int right) {
        int pl = left; // 왼쪽 끝 인덱스
        int pr = right; // 오른쪽 끝 인덱스
        int pivot = arr[(pl + pr) / 2]; // 피벗(가운데 요소)

        do {
            while (arr[pl] > pivot) pl++; //
            while (arr[pr] < pivot) pr--;

            if (pl <= pr) {
                swap(arr, pl++, pr--);
            }
        } while (pl <= pr);

        if (left < pr) quickSort(arr, left, pr);
        if (pl < right) quickSort(arr, pl, right);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        quickSort(arr, 0, n - 1);

        for (int i : arr) {
            System.out.println(i);
        }
    }
    */
}
