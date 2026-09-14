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
        List<pair> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int v = sc.nextInt();
            list.add(new pair(s,e,v));
        }
        list.sort((a,b) -> {
            return a.x-b.x;
        });
        pair[] arr = new pair[n];
        int cnt = 0;
        for(pair tmp : list) {
            arr[cnt] = tmp;
            cnt++;
        }

        memo = new int[m + 1][n + 1];

        for(int i = 1; i <= m; i++) {
            for(int j = 0; j < n; j++) {
                int v = arr[j].cnt;
                if(arr[j].x <= i && arr[j].y >= i) {

                    if(i == 1) {
                        memo[i][j] = 1;
                        continue;
                    }
                    for(int p = 0; p < n; p++) {
                        if(memo[i - 1][p] != 0) {
                            memo[i][j] = Math.max(memo[i][j], Math.abs(arr[p].cnt - v) + memo[i - 1][p]);
                        }
                    }
                }
            }
        }
        ans = 0;
        for(int i = 0; i < n; i++) {
            ans = Math.max(memo[m][i], ans);
        }
        System.out.println(ans - 1);
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


