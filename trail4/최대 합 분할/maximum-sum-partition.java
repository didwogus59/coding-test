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
//        m = sc.nextInt();
        arr = new int[n];
//        arr2 = new int[10001];
//        list = new ArrayList<>();

        int sum = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        int max = (sum / 2);
        memo = new int[n][sum + 1];

        memo[0][arr[0]] = arr[0];
        for(int i = 1; i < n; i++) {
            int now = arr[i];
            if(now <= max)
                memo[i][now] = now;
            for(int j = 0; j <= max; j++) {
                memo[i][j] = Math.max(memo[i][j], memo[i-1][j]);
                if(memo[i - 1][j] == 0)
                    continue;
                if(now + j <= max) {
                        memo[i][now + j] = Math.max(memo[i][now + j], memo[i - 1][j] + now);
                }
                if(j >= now) {
                    memo[i][j - now] = Math.max(memo[i][j - now], memo[i - 1][j]);
                }
                else {
                    memo[i][now - j] = Math.max(memo[i][now - j], memo[i-1][j] + now - j);
                }
            }
            ans = Math.max(ans, memo[i][0]);
//            for(int j = 0; j <= max; j++) {
//                System.out.printf("%d ",memo[i][j]);
//            }
//            System.out.println();
        }

        System.out.println(ans);
    }
    static int gap(int sum, int x) {
        int y = sum - x;
        return x > y ? x - y : y - x;
    }
    static void dp(int a, int b, int max, int now) {

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


