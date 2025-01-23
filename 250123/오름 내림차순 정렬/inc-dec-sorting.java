import java.util.*;
public class Main {
    static Integer[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new Integer[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for(Integer i : arr) {
            System.out.printf("%d ",i);
        }
        System.out.printf("\n");
        Arrays.sort(arr,Collections.reverseOrder());
        
        
        for(Integer i : arr) {
            System.out.printf("%d ",i);
        }
    }
}