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
    static int[][] memo;
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
        memo = new int[n + 1][m + 1];

        int sum = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= m; j++) {
                memo[i][j] = -5000000;
            }
        }
        memo[0][1] = arr[0];
        memo[1][1] = Math.max(arr[0] + arr[1], arr[1]);
        for(int i = 2; i < n; i++) {
            memo[i][1] = Math.max(memo[i-1][1] + arr[i], arr[i]);
            for(int j = 2; j <= m; j++) {
                memo[i][j] = memo[i - 1][j] + arr[i];
                for(int p = i - 2; p >= 0; p--) {
                    memo[i][j] = Math.max(memo[i][j], memo[p][j - 1] + arr[i]);
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, memo[i][m]);
        }
        System.out.println(ans);
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
    /*
    509359750
    170735726
    * */
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


