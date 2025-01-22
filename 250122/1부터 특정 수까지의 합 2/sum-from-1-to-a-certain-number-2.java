import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n + 1];
        System.out.println(fact(n));
    }
    public static int fact(int n) {
        if(n == 0) {
            return 0;
        }
        if(arr[n] == 0) {
            arr[n] = fact(n-1) + n;
        }
        return arr[n];
    }
}