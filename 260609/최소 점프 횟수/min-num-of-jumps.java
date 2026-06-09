import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int ans = -1;
    static int len;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        len = sc.nextInt();
        int[] arr = new int[len];
        for(int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        bt(arr, 0, 0);
        System.out.println(ans);
    }
    static void bt(int[] arr,int now, int cnt) {
        if(now == len - 1) {
            if(ans == -1)
                ans = cnt;
            ans = Math.min(ans, cnt);
        }
        else {
            int dis = arr[now];
            for(int i = 1; i <= dis; i++) {
                if(now + i <= len - 1) {
                    bt(arr, now + i, cnt + 1);
                }
            }
        }
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < len && y < len;
    }
}


