import java.io.*;

public class Boj11931 {

    static void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    static void quickSort(int[] arr, int left, int right) {
        int pl = left;
        int pr = right;
        int pivot = arr[(pl + pr) / 2];

        do {
            while (arr[pl] > pivot) pl++;
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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        System.out.print("요솟수: ");
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("내림차순 정렬합니다.");
        quickSort(arr, 0, n - 1);

        for (int i : arr) {
            bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
    }
}
