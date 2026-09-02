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
        arr = new int[n + 1];
//        arr2 = new int[10001];
//        list = new ArrayList<>();
        List<pair> list = new ArrayList<>();

        int sum = 0;
        for(int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        memo = new int[n + 1][4];
        memo[1][1] = arr[1];
        memo[2][0] = arr[2];
        memo[2][2] = arr[1] + arr[2];
        ans = 0;
        for(int i = 3; i <= n; i++) {
            if(memo[i - 2][0] != 0)
                memo[i][0] = memo[i - 2][0];
            memo[i][1] = Math.max(memo[i-2][1], memo[i-1][0]);
            memo[i][2] = Math.max(memo[i-2][2], memo[i-1][1]);
            memo[i][3] = Math.max(memo[i-2][3], memo[i-1][2]);
            for(int j = 0; j < 4; j++) {
                if(memo[i][j] != 0)
                    memo[i][j] += arr[i];
            }
        }
        for(int i = 0; i < 4; i++) {
            ans = Math.max(ans, memo[n][i]);
        }
//        for(int i = 0; i <= n; i++) {
//            for(int j = 0; j < 4; j++) {
//                System.out.printf("%d ",memo[i][j]);
//            }
//            System.out.printf("%d", arr[i]);
//            System.out.println();
//        }
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


