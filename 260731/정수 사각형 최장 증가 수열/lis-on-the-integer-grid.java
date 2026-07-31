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
        memo = new int[n + 1][n + 1];
        arr = new int[n + 1][n + 1];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(memo[i][j] == 0)
                    dp(i,j);
            }
        }
//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < n; j++) {
//                System.out.printf("%d ", memo[i][j]);
//            }
//            System.out.println();
//        }
        System.out.println(ans);
    }
    static int dp(int x, int y) {
        if(!inRange(x,y,n,n))
            return 0;
        if(memo[x][y] == 0) {
            int up = 0;
            if(x > 0) {
                if (arr[x - 1][y] < arr[x][y])
                    up = dp(x - 1, y);
            }
            int down = 0;
            if(x < n) {
                if(arr[x+1][y] < arr[x][y])
                    down = dp(x + 1, y);
            }
            int right = 0;
            if(y < n) {
                if(arr[x][y + 1] < arr[x][y])
                    right = dp(x, y + 1);
            }
            int left = 0;
            if(y > 0)
                if(arr[x][y-1] < arr[x][y])
                    left = dp(x, y - 1);

            int big1 = Math.max(up, down);
            int big2 = Math.max(right, left);
            int big = Math.max(big1, big2);
            memo[x][y] = big + 1;
        }
        if(ans < memo[x][y])
            ans = memo[x][y];
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


