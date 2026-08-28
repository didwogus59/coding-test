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
    static int[][][] memo2;
    static int[] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[10001];

        memo = new int[10001];
        memo[0] = 1;
        dp(n);
        System.out.println(memo[n]);
    }
    static int dp(int x) {
        if(memo[x] == 0) {
            int sum = 0;
            if(x >= 1) {
                sum += dp(x - 1);
            }
            if(x >= 2) {
                sum += dp(x - 2);
            }
            if(x >= 5) {
                sum += dp(x - 5);
            }
//            System.out.printf("%d %d\n",sum,x);
            memo[x] = sum % 10007;
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


