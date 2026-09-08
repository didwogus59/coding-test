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
    static long[][] memo;
    static int[] memo2;
    static int[] arr;
    static int[] arr2;
    static int n;
    static List<pair> list;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n * 2];
        arr2 = new int[n * 2];
        memo = new long[n + 1][41];

        int sum = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= 40; j++) {
                memo[i][j] = -100;
            }
        }
        int cnt = 1;
        memo[0][20 - arr[0]] = 1;
        memo[0][20 + arr[0]] = Math.max(memo[0][20 + arr[0]] + 1, 1);
        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= 40; j++) {
                long now = memo[i-1][j];
                if(now != -100) {
                    if(j + arr[i]<= 40) {
//                        System.out.printf("%d %d\n",memo[i][j + arr[i]],now);
                        memo[i][j + arr[i]] = Math.max(memo[i][j + arr[i]] + now, now);
                    }
                    if(j - arr[i] >= 0) {
//                        System.out.printf("%d %d\n",memo[i][j - arr[i]], now);
                        memo[i][j - arr[i]] = Math.max(memo[i][j - arr[i]] + now, now);
                    }
                }
            }
        }
        if(memo[n - 1][m + 20] != -100)
            System.out.println(memo[n - 1][m + 20]);
        else
            System.out.println(0);
    }
    static int dp(int b, int r, int sum) {
        if(b > n || r > n) {
            return 0;
        }
        return 1;
    }
    static int gap(int sum, int x) {
        int y = sum - x;
        return x > y ? x - y : y - x;
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


