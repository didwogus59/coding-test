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
    static int[] arr;
    static int[] arr2;
    static int n;
    static boolean chk;
    static List<pair> list;
    static int cnt2 = 0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        m = sc.nextInt();
        String tmp = sc.next();
        String tmp2 = sc.next();

        n = tmp.length();
        m = tmp2.length();

        arr = new int[1001];
        arr2 = new int[1001];
        memo = new int[n][m];
        for(int i = 0; i < n; i++) {
            arr[i] = tmp.charAt(i) - 'A';
        }
        for(int i = 0; i < m; i++) {
            arr2[i] = tmp2.charAt(i) - 'A';
        }

        ans = 0;
        int chk = 0;
        for(int i = 0; i < m; i++) {
            if(arr[0] == arr2[i])
                chk = 1;
            memo[0][i] = chk;
            ans = Math.max(memo[0][i], ans);
        }
        chk = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == arr2[0])
                chk = 1;
            memo[i][0] = chk;
            ans = Math.max(memo[i][0], ans);
        }
        for(int i = 1; i < n; i++) {
            int max = 0;
            for(int j = 1; j < m; j++) {
                max = Math.max(max, memo[i - 1][j - 1]);
                memo[i][j] = max + (arr[i] == arr2[j] ? 1 : 0);
                for(int p = 0; p < i; p++) {
                    memo[i][j] = Math.max(memo[i][j], memo[p][j-1] + (arr[i] == arr2[j] ? 1 : 0));
                }
                ans = Math.max(ans, memo[i][j]);
            }
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


