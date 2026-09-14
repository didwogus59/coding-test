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
    static int[][] arr;
    static int[] arr2;
    static int n;
    static List<pair> list;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][3];

        memo = new int[n + 1][3][3];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        memo[0][0][0] = arr[0][0];
        memo[0][1][1] = arr[0][1];
        memo[0][2][2] = arr[0][2];
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                for(int p = 0; p < 3; p++) {
                    if (j == 0) {
                        memo[i][j][p] = Math.max(memo[i - 1][1][p], memo[i - 1][2][p]);
                    }
                    if (j == 1) {
                        memo[i][j][p] = Math.max(memo[i - 1][0][p], memo[i - 1][2][p]);
                    }
                    if (j == 2) {
                        memo[i][j][p] = Math.max(memo[i - 1][1][p], memo[i - 1][0][p]);
                    }
                    memo[i][j][p] += arr[i][j];
                }
            }
        }
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(i != j) {
                    ans = Math.max(ans, memo[n-1][i][j]);        
                }
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


