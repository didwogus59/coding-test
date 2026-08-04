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
    static int[][] memo;
    static int[][][] memo2;
    static int[][] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        memo2 = new int[n + 1][n + 1][2];

        arr = new int[n + 1][n + 1];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        memo = new int[n + 1][n + 1];
        dp(n - 1, n - 1);


        System.out.println(memo[n-1][n-1]);
    }
    static int dp(int x, int y) {
        if(memo[x][y] == 0) {
            int left = 2000000000;
            int up = 2000000000;
            if(x > 0) {
                up = dp(x-1, y);
            }
            if(y > 0) {
                left = dp(x, y - 1);
            }
            if(x == 0 && y == 0) {
                memo[x][y] = arr[x][y];
            }
            else {
                memo[x][y] = Math.max(arr[x][y], Math.min(left, up));
            }
        }
        return memo[x][y];
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


