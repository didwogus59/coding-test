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
    static int[][] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        memo = new int[101][101];
        arr = new int[101][101];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(dp(n-1,n - 1));
    }
    static int dp(int x, int y) {
        if(x == 0 && y == 0)
            return arr[x][y];
        if(memo[x][y] == 0) {
            int up = 0;
            if(x > 0)
                up = dp(x-1,y);
            int right = 0;
            if(y > 0)
                right = dp(x, y - 1);
            int bigger = Math.max(up, right);
            if(bigger == 0)
                bigger = 1000000001;
            memo[x][y] = Math.min(bigger, arr[x][y]);
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


