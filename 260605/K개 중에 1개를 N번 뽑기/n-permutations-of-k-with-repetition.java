import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];
        List<String> strs = new ArrayList<>();
        bt(arr, n, 0, strs);
        
        for(String str : strs) {
            System.out.print(str);
        }
    }

    static void bt(int[] arr, int n, int cnt, List<String> strs) {
        if(cnt == arr.length) {
            StringBuffer sb = new StringBuffer();
            for(int i : arr) {
                sb.append(i);
                sb.append(" ");
            }
            sb.append("\n");
            strs.add(sb.toString());
            
        }
        else {
            for(int i = 1; i <= n; i++) {
                arr[cnt] = i;
                bt(arr,n,cnt + 1,strs);
            }
        }
    }

}


