import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int ans = 1000;
    static int len;
    static int m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] memo;
    static int[][][] memo2;
    static int[] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr = new int[n + 1];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        memo = new int[n + 1];
        ans = 0;
        for(int i = n - 1; i >= 0; i--) {
            int now = dp(i);
            ans = Math.max(ans, now);
        }


        System.out.println(ans);
    }
    static int dp(int x) {
        int now = arr[x];
        if(memo[x] == 0) {
            int max = 0;
            for(int i = x - 1; i >= 0; i--) {
                if(arr[i] > now) {
                    int cnt = dp(i);
                    max = Math.max(max, cnt);
                }
            }
            memo[x] = max + 1;
        }
        return memo[x];
    }

    //
    static boolean inRange(int x, int y, int lenX, int lenY) {
        return x >= 0 && y >= 0 && x < lenX && y < lenY;
    }
    static class pair {
        int x;
        int y;
        int cnt = 0;
        int now = 0;
        int min;
        int max;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public pair(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}


