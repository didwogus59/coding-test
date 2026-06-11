import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int ans = 0;
    static int len;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < m; i++) {
            ans ^= arr[i];
        }
        bt(arr, 0, 0, 0, m);
        System.out.println(ans);
    }
    static void bt(int[] arr, int num, int now, int cnt, int max) {
        if(cnt == max) {
            ans = Math.max(num, ans);
        }
        else {
            if(now < arr.length) {
                bt(arr, num ^ arr[now], now + 1, cnt + 1, max);

                bt(arr, num, now + 1, cnt, max);
            }
        }
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < len && y < len;
    }
}


