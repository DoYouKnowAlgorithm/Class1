package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11931 {
    static int[] arr;
    static int[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        temp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0, arr.length - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void merge(int start, int mid, int end) {
        int leftIdx = start; // 왼쪽 배열의 인덱스
        int midIdx = mid + 1; // 오른쪽 배열의 인덱스
        int index = start; // 임시 배열 인덱스
        int i;

        while (leftIdx <= mid && midIdx <= end) { //양쪽 배열 인덱스가 범위를 벗어나지 않는 동안
            //왼쪽과 오른쪽 배열 값 중 큰 값을 임시배열에 넣는다.
            if (arr[leftIdx] >= arr[midIdx]) temp[index++] = arr[leftIdx++];
            else temp[index++] = arr[midIdx++];
        }

        // 왼쪽 배열이 1 4, 오른쪽 배열이 5, 2라면
        // while문이 끝났을 때 왼쪽 배열의 값 1만 temp에 들어가지 않은 상태가 된다.
        // 이렇게 남은 쪽의 값들을 임시배열에 넣는다.
        if (leftIdx <= mid) {
            for (i = leftIdx; i <= mid; i++) {
                temp[index++] = arr[i];
            }
        } else {
            for (i = midIdx; i <= end; i++) {
                temp[index++] = arr[i];
            }
        }

        // 임시배열의 정렬된 값들을 원래 배열에 옮긴다.
        for (i = start; i <= end; i++) {
            arr[i] = temp[i];
        }
    }

    static void mergeSort(int start, int end) {
        // 배열의 원소가 1개가 될 때까지 나누기
        if (start < end) {
            int mid = ( start + end ) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);
            merge(start, mid, end);
        }
    }
}
