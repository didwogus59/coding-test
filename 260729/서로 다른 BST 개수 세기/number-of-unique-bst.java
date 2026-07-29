import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int ans = 0;
    static int len;
    static int m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static long[] memo;
    static long[] memo2;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        memo = new long[2000];
        memo2 = new long[2000];

        memo[0] = 1;
        memo[1] = 1;
        dp(n);
        System.out.println(memo[n]);
    }
    static long dp(int n) {
        if(memo[n] == 0) {
            long ans = 0;
            for(int i = 0; i <= n - 1; i++) {
                ans += dp(i) * dp(n - 1 - i);
            }
            memo[n] = ans;
        }
        return memo[n];
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


