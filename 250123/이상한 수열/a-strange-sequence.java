import java.util.*;
public class Main {
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[16];
        arr[1] = 1;
        arr[2] = 2;
        System.out.println(fact(n));
    }
    public static int fact(int n) {
        if(arr[n] == 0)
            arr[n] = fact(n/3) + fact(n-1);
        return arr[n];
    }
}