import java.util.*;
public class Main {
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n *= 2;
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int max = 0;
        for(int i = 0; i < n / 2; i++) {
            if(max < arr[i] + arr[n - 1 - i]) {
                max = arr[i] + arr[n - 1 - i];
            }
        }
        System.out.println(max);
    }
}