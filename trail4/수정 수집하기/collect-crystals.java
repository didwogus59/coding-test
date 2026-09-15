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
    static int[][][] memo;
    static int[] memo2;
    static int[] arr;
    static int[] arr2;
    static int n;
    static List<pair> list;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        String cri = sc.next();

        arr = new int[n];
        arr2 = new int[n];
        for(int i = 0; i < n; i++) {
            if(cri.charAt(i) == 'L') {
                arr[i] = 1;
            }
            else
                arr2[i] = 1;
        }
        memo = new int[n + 1][2][m + 1];

        memo[0][0][0] = arr[0];
        memo[0][1][1] = arr2[0];

        for(int i = 1; i < n; i++) {
            memo[i][0][0] = memo[i - 1][0][0] + arr[i];
            memo[i][1][1] = memo[i - 1][1][0] + arr2[i];
            for(int j = 1; j <= m; j++) {
                memo[i][0][j] = Math.max(memo[i - 1][0][j], memo[i - 1][1][j - 1]) + arr[i];
                memo[i][1][j] = Math.max(memo[i - 1][1][j], memo[i - 1][0][j - 1]) + arr2[i];

            }
        }
        for(int i = 0; i <= m; i++) {
            ans = Math.max(ans , memo[n - 1][0][i]);
            ans = Math.max(ans , memo[n - 1][1][i]);
        }
        System.out.println(ans);
    }
    static int dp(String num, int now) {
        int n = (int)num.charAt(now) - 48;

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


