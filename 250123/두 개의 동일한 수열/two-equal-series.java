import java.util.*;
public class Main {
    static int[] arr1;
    static int[] arr2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr1 = new int[n];
        for(int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        arr2 = new int[n];
        for(int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }

        Arrays.sort(arr1);
        
        Arrays.sort(arr2);
        boolean chk = true;
        for(int i = 0; i < n; i++) {
            if(arr1[i] != arr2[i]) {
                chk = false;
                break;
            }
        }
        if(chk) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}