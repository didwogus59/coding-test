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
    static int[] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
//        m = sc.nextInt();
        arr = new int[n + 1];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        memo = new int[n + 1][2];
        dp(n-1);
        dp2(n-1);
        for(int i = n - 1; i >= 0; i--) {
            dp(i);
            dp2(i);
            int inc = memo[i][0];
            int dec = memo[i][1];
            ans = Math.max(ans, inc + dec);

        }
//        for(int i = 0; i < n; i++) {
//            System.out.printf("%d ",memo[i][0]);
//        }
//        System.out.println();
//
//        for(int i = 0; i < n; i++) {
//            System.out.printf("%d ",memo[i][1]);
//        }
//        System.out.println();
        System.out.println(ans - 1);
    }
    static int dp(int x) {
        if(memo[x][0] == 0) {
            int max = 0;
            int now = arr[x];
            for(int i = x - 1; i >= 0; i--) {
                if(arr[i] < now) {
                    max = Math.max(max, dp(i));
                }
            }
            memo[x][0] = max + 1;
        }
        return memo[x][0];
    }

    static int dp2(int x) {
        if(memo[x][1] == 0) {
            int max = 0;
            int now = arr[x];
            for(int i = x + 1; i < n; i++) {
                if(arr[i] < now) {
                    max = Math.max(max, dp2(i));
                }
            }
            memo[x][1] = max + 1;
        }
        return memo[x][1];
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


