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
        m = sc.nextInt();
        arr = new int[10001];

        memo = new int[10001];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            memo[arr[i]] = 1;
        }

        dp(m);
//        for(int i : memo) {
//            System.out.printf("%d ", i);
//        }
//        System.out.println();
        if(memo[m] == m + 1)
            memo[m] = -1;
        System.out.println(memo[m]);
    }
    static int dp(int x) {
        if(memo[x] == 0) {
            int max = m;
            for(int i = 0; i < n; i++) {
                if(x - arr[i] >= 0) {
                    max = Math.min(max, dp(x - arr[i]));
                }
            }
            memo[x] = max + 1;
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


