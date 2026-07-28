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
    static int[] memo;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        memo = new int[2000];
        memo[0] = 0;
        memo[1] = 0;
        memo[2] = 1;
        memo[3] = 1;
        dp(n);
        System.out.println(memo[n]);
    }
    static int dp(int n) {
        if(n < 2)
            return 0;
        if(memo[n] == 0)
            memo[n] = (dp(n - 3) + dp(n - 2)) % 10007;
        return memo[n];
    }
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


