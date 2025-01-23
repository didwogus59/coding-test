import java.util.*;
public class Main {
    static String[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        Arrays.sort(arr);
        for(String str : arr) {
            System.out.println(str);
        }
    }
}