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
    static int[] memo;
    static int[][][] memo2;
    static int[] arr;
    static int[] arr2;
    static int n;
    static List<pair> list;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[10001];
        arr2 = new int[10001];
        list = new ArrayList<>();
        memo = new int[30001];
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            pair tmp = new pair(x,y);
            list.add(tmp);
        }

        list.sort((a, b) -> {
            if(a.x != b.x)
                return a.x-b.x;
            return b.y - a.y;
        });



        System.out.println(dp(m, n - 1));
    }
    static int dp(int sum, int idx) {
        if(sum <= 0 || idx < 0)
            return 0;

        pair tmp = list.get(idx);
        int now = tmp.x;

        int plus = 0;
        int pass = dp(sum, idx - 1);

        if (sum >= now) {
            plus = dp(sum - now, idx - 1) + tmp.y;
        }
        return Math.max(plus, pass);
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


