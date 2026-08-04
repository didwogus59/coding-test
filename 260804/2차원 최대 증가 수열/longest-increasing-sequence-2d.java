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
    static int[][][] memo2;
    static int[][] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n + 1][m + 1];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        memo = new int[n + 1][m + 1];

        memo[0][0] = 1;
        for(int i = n - 1; i >= 0; i--) {
            for(int j = m - 1; j >= 0; j--) {
                ans = Math.max(dp(i, j), ans);
            }
        }
        System.out.println(ans);
    }
    static int dp(int x, int y) {
        if(memo[x][y] != 0) {
            return memo[x][y];
        }
//        System.out.printf("now %d\n", x);
        int max = 0;
        int now = arr[x][y];
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                if(arr[i][j] < now) {
                    if(memo[i][j] != - 1) {
                        max = Math.max(dp(i,j), max);
                    }
                }
            }
        }
        if(max > 0)
            memo[x][y] = max + 1;
        else
            memo[x][y] = -1;
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


