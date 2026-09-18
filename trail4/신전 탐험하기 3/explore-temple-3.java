import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int ans = 0;
    static int cnt = 0;
    static int len;
    static int m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] memo;
    static int[] memo2;
    static int[][] arr;
    static int[] arr2;
    static int n;
    static boolean chk;
    static List<pair> list;
    static int cnt2 = 0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        memo = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < m; i++) {
            memo[0][i] = arr[0][i];
        }
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int p = 0; p < m; p++) {
                    if(j != p) {
                        memo[i][j] = Math.max(memo[i][j], memo[i-1][p]);
                    }
                }
                memo[i][j] += arr[i][j];
            }
        }
        for(int i = 0; i < m; i++) {
            ans = Math.max(ans, memo[n - 1][i]);
        }
        System.out.println(ans);
    }

    static void dp(int[] arr, int now, int left, int end) {
        if(chk) {
            if (now == n) {
                if(left == 0) {
                    cnt++;
                    if (end == cnt) {
                        chk = false;
                    }
                }
            }
            else {
                for (int i = arr[now - 1]; i <= left; i++) {
                    if (chk) {
                        arr[now] = i;
                        int tmp = cnt;
                        int leftN = left - i * (n - now);
                        if(leftN >= 0) {
                            if (memo[now][leftN] == 0) {
                                dp(arr, now + 1, left - i, end);
                                memo[now][leftN] = cnt - tmp;
                            } else if (cnt + memo[now][leftN] < end) {
                                cnt += memo[now][leftN];
                            } else {
                                dp(arr, now + 1, left - i, end);
                            }
                        }
                        else {
                            break;
                        }
                    }
                }
            }
        }
    }

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


