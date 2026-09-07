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
        m = sc.nextInt();
        arr = new int[n + 1];
//        arr2 = new int[n + 1];
        memo = new int[n + 2][m + 2];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        if(arr[0] > 0)
            memo[0][0] = arr[0];
        else
            memo[0][1] = arr[0];

        ans = arr[0];

        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= m; j++) {
                if(arr[i] >= 0) {
                    if(memo[i - 1][j] < 0)
                        memo[i][j] = arr[i];
                    else
                        memo[i][j] = memo[i - 1][j] + arr[i];
                    ans = Math.max(memo[i][j], ans);
                }
                else {
                    if(j < m) {
                        if (memo[i - 1][j] < 0)
                            memo[i][j + 1] = arr[i];
                        else
                            memo[i][j + 1] = memo[i - 1][j] + arr[i];
                        ans = Math.max(memo[i][j + 1], ans);
                    }
                }
            }
        }

        System.out.println(ans);
    }
    static int gap(int sum, int x) {
        int y = sum - x;
        return x > y ? x - y : y - x;
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


