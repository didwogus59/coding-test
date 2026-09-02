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
//        arr2 = new int[10001];
//        list = new ArrayList<>();
        List<pair> list = new ArrayList<>();

        int sum = 0;
        for(int i = 0; i < n; i++) {
            int e = sc.nextInt();
            int t = sc.nextInt();
            sum += t;
            list.add(new pair(e,t));
        }
        list.sort((a,b) -> {
            return a.y - b.y;
        });

        memo = new int[sum + 1];
        for(pair tmp : list) {
            int e = tmp.x;
            int t = tmp.y;
            for(int i = sum; i > t; i--) {
                if(memo[i - t] != 0) {
                    memo[i] = Math.max(memo[i-t] + e, memo[i]);
                }
            }
            memo[t] = Math.max(e, memo[t]);
        }
        ans = -1;
        for(int i = sum; i >= 0; i--) {
            if(memo[i] >= m) {
                ans = i;
            }
        }

        System.out.println(ans);
    }
    static int gap(int sum, int x) {
        int y = sum - x;
        return x > y ? x - y : y - x;
    }
    static void dp(int a, int b, int max, int now) {

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


