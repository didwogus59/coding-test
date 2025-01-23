import java.util.*;
public class Main {
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[21];
        arr[1] = 2;
        arr[2] = 4;
        System.out.println(fact(n));
    }
    public static int fact(int n) {
        if(arr[n] == 0)
            arr[n] = (fact(n - 1) * fact(n - 2)) % 100;
        return arr[n];
    }
}