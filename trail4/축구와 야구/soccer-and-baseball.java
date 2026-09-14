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
    static int[][][][] memo;
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
        arr2 = new int[n];
        memo = new int[n][12][10][2];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            arr2[i] = sc.nextInt();
        }

        memo[0][1][0][0] = arr[0];
        memo[0][0][1][1] = arr2[0];
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                for (int p = 11; p >= 0; p--) {
                    for (int q = 9; q >= 0; q--) {
                        if (p > 0) {
                            memo[i][p][q][0] = Math.max(Math.max(memo[j][p - 1][q][0],memo[j][p - 1][q][1]) + arr[i], memo[i][p][q][0]);
                        }
                        if (q > 0) {
                            memo[i][p][q][1] = Math.max(Math.max(memo[j][p][q - 1][0],memo[j][p][q - 1][1]) + arr2[i], memo[i][p][q][1]);
                        }

//                        if(p > 0 && q > 0 && memo[j][p - 1][q - 1] != 0)
//                            memo[i][p][q] = Math.max(memo[j][p-1][q - 1] + arr2[i] + arr[i], memo[i][p][q]);
//                    System.out.printf("%d %d %d\n",p,q, memo[p][q]);
                    }
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, memo[i][11][9][0]);
            ans = Math.max(ans, memo[i][11][9][1]);
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


