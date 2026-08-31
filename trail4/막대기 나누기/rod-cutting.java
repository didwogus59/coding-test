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
    static int[] arr2;
    static int n;
    static List<pair> list;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
//        m = sc.nextInt();
        arr = new int[10001];
//        arr2 = new int[10001];
//        list = new ArrayList<>();
        memo = new int[30001];
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr[i + 1] = x;
        }
        for(int i = 1; i <= n; i++) {
            for(int j = i; j <= n; j++) {
                memo[j] = Math.max(memo[j - i] + arr[i], memo[j]);
            }
        }

        System.out.println(memo[n]);
    }
    static int dp(int sum, int idx) {
        if(sum <= 0 || idx < 1)
            return 0;
//        pair tmp = list.get(idx);
        if(memo[sum] != 0)
            return memo[sum];
        int now = arr[idx];

        int plus = 0;
        int pass = dp(sum, idx - 1);

        if (sum >= idx) {
            plus = dp(sum - idx, idx) + now;
        }
        memo[sum] = Math.max(plus, pass);
        return memo[sum];
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


