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

        arr = new int[n + 1];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        memo = new int[n + 1];
        for(int i = n - 1; i >= 0; i--) {
            ans = Math.max(dp(i), ans);
        }
//        for(int i = 0; i < n; i++) {
//            System.out.print(memo[i]);
//        }
//        System.out.println();
        System.out.println(ans - 1);
    }
    static int dp(int x) {
        if(x == 0)
            return 1;

        if(memo[x] != 0) {
            return memo[x];
        }
//        System.out.printf("now %d\n", x);
        int max = 0;
        for(int i = 0; i < x; i++) {
            if(arr[i] + i >= x) {
                if(memo[i] != -1)
                    max = Math.max(max, dp(i));
            }
        }
        if(max > 0)
            memo[x] = max + 1;
        else
            memo[x] = -1;
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


