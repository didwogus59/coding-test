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
        memo[1] = 2;
        memo[2] = 7;
        memo2[0] = 0;
        memo2[1] = 0;
        memo2[2] = 0;
        memo2[3] = 2;

        dp(n);
        System.out.println(memo[n]);
    }
    static long dp(int n) {
        if(memo[n] == 0) {
            memo[n] = (dp(n - 1) * 2 + dp(n - 2) * 3) % 1000000007;
            memo2[n] = (memo[n - 3] * 2 + memo2[n -1]) % 1000000007;;
            memo[n] = (memo[n] + memo2[n]) % 1000000007;
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


