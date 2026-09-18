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
        arr = new int[n];
        arr2 = new int[n];
        String n1 = sc.next();
        for(int i = 0; i < n; i++) {
            arr[i] = n1.charAt(i) - '0';
        }
        String n2 = sc.next();
        for(int i = 0; i < n; i++) {
            arr2[i] = n2.charAt(i) - '0';
        }
        memo = new int[n + 1][10];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 10; j++) {
                memo[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0; i < 10; i++) {
            memo[0][i] = move((arr[0] + i) % 10 ,arr2[0]) + i;
        }
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 10; j++) {
                for(int p = 0; p < 10; p++) {
                    int m = (j + p + arr[i]) % 10;
                    memo[i][(j + p) % 10] = Math.min(memo[i][(j + p) % 10], memo[i-1][j] + p + move(m, arr2[i]));
//                    System.out.printf("%d %d %d %d\n",i,j,p,memo[i][(j + p) % 10]);
                }
            }
        }
        ans = Integer.MAX_VALUE;
        for(int i = 0; i < 10; i++) {
            ans = Math.min(ans, memo[n - 1][i]);
        }
        System.out.println(ans);
    }

    static int move(int a, int b) {
        if(a >= b) {
            return a - b;
        }
        else// 1 -> 2
            return a + 10 - b;
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


