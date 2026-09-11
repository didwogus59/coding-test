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
    static long[][][] memo;
    static int[] memo2;
    static int[] arr;
    static int[] arr2;
    static int n;
    static List<pair> list;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
//        m = sc.nextInt();
        arr = new int[n * 2];
        arr2 = new int[n * 2];
        memo = new long[n + 1][4][4];

        int sum = 0;
//        for(int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }
        memo[0][0][0] = 1;
        memo[0][1][0] = 1;
        memo[0][0][1] = 1;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                for(int p = 0; p < 3; p++) {
                    memo[i][0][p] = (memo[i][0][p] + memo[i - 1][j][p]) % 1000000007;
//                    System.out.printf("G : %d  %d\n", j, p);
                }
                for(int p = 1; p < 3; p++) {
                    memo[i][0][p] = (memo[i][0][p] + memo[i - 1][j][p - 1]) % 1000000007;
//                    System.out.printf("T : %d  %d\n", j, p);
                }
            }

            for(int j = 1; j < 3; j++) {
                for (int p = 0; p < 3; p++) {
                    memo[i][j][p] += (memo[i][j][p] + memo[i - 1][j - 1][p]) % 1000000007;
                }
            }
        }
        long ans = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                ans = (ans + memo[n-1][i][j]) % 1000000007;
//                System.out.printf("%d %d : %d\n",i,j,memo[n-1][i][j]);
            }
        }
        System.out.println(ans);
    }
    static int dp(int b, int r, int sum) {
        if(b > n || r > n) {
            return 0;
        }
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


