import java.util.*;
public class Main {
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        System.out.println(fact(n - 1));
    }
    public static int fact(int n ) {
        if(arr[n] == 0) {
            arr[n] = fact(n - 1) + fact(n - 2);
        }
        return arr[n];
    }

}