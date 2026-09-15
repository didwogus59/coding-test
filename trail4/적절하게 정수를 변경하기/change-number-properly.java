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
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        memo = new int[n + 1][5][m + 1];

        for(int i = 1; i < 5; i++) {
            if(arr[0] == i)
                memo[0][i][0] = 1;
        }
        memo[0][arr[0]][0] = 1;

        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= 4; j++) {
                for(int p = 0; p <= m; p++) {
                    int smi = arr[i] == j ? 1 : 0;
                    int move = 0;
                    for(int q = 1; q <= 4; q++) {
                        if(q != j && p > 0) {
                            move = Math.max(move, memo[i-1][q][p - 1]);
                        }
                    }
                    int stop = memo[i-1][j][p];

                    memo[i][j][p] = Math.max(stop, move) + smi;
                }
            }
        }
        ans = 0;
        for(int i = 0; i <= 4; i++) {
            for(int j = 0; j <= m; j++) {
                ans = Math.max(memo[n-1][i][j], ans);
            }
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


