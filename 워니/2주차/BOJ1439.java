import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ1439 {
    static Scanner scanner = new Scanner(System.in);
    static String[] arr0;
    static String[] arr1;

    public static void main(String[] args) throws IOException {
        String n = scanner.next();
        arr0 = new String[n.length()];
        arr1 = new String[n.length()];
        arr0 = n.split("1");
        arr1 = n.split("0");
        
        System.out.println(getMinArr0OrArr1());
    }

    private static long getMinArr0OrArr1() {
        return Math.min(getCountInArr0(), getCountInArr1());
    }

    private static long getCountInArr0() {
        return Arrays.stream(arr1).filter(i -> !i.isEmpty()).count();
    }

    private static long getCountInArr1() {
        return Arrays.stream(arr1).filter(i -> !i.isEmpty()).count();
    }
}
