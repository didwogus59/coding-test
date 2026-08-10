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
    static int[][][] memo2;
    static int[] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
//        m = sc.nextInt();
        arr = new int[n + 1];
        memo = new int[n + 1][2];
        List<pair> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int pay = sc.nextInt();
            list.add(new pair(x,y,pay));
        }
        Collections.sort(list, (a,b) -> {
            return a.x - b.x;
        });

        dp(n-1, list);
        for(int i = n - 1; i >= 0; i--) {
            dp(i, list);
        }
        for(int i = n - 1; i >= 0; i--) {
            ans = Math.max(ans, memo[i][0]);
        }
//        for(int i = 0; i < n; i++) {
//            System.out.printf("%d ",memo[i][0]);
//        }
//        System.out.println();
//
//        for(int i = 0; i < n; i++) {
//            System.out.printf("%d ",memo[i][1]);
//        }
//        System.out.println();
        System.out.println(ans);
    }
    static int dp(int x, List<pair> list) {
        if(memo[x][0] == 0) {
            int max = 0;
            int i = list.get(x).x;
            int j = list.get(x).y;
            int pay = list.get(x).cnt;
            for(int p = x - 1; p >= 0; p--) {
                if(list.get(p).y < i) {
                    max = Math.max(max, dp(p, list));
                }
            }
            memo[x][0] = max + pay;
        }
        return memo[x][0];
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


