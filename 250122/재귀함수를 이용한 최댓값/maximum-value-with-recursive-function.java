import java.util.*;
public class Main {
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(fact(n - 1,max));
    }
    public static int fact(int n, int max) {
        if(n == -1)
            return max;
        if(arr[n] > max)
            return fact(n-1,arr[n]);
        return fact(n-1,max);
    }
}