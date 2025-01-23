import java.util.*;
public class Main {
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(recursive(n-1, arr[0]));
    }
    public static int recursive(int n, int now) {
        if(n == 0)
            return now;
        if(now % arr[n] == 0)
            return recursive(n - 1, now);
        int mul = 1;
        for(int i = 2; i <= arr[n]; i++) {
            if(now % i == 0 && arr[n] % i == 0)
                mul = i;
        }
        return recursive(n - 1, now * arr[n] / mul);
    }
}