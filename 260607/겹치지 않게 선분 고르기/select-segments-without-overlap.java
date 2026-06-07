import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int ans = 0;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        pair[] pairs = new pair[n];
        for(int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            pairs[i] = new pair(l,r);
        }

        Arrays.sort(pairs, (a, b) -> {
            return a.y - b.y;
        });
        for(int i = 0; i < n; i++) {
            bt(pairs, i, 0, 0);
        }
        System.out.println(ans);
    }

    static void bt(pair[] pairs,int now, int cnt, int end) {
        if(pairs.length == now) {
            if(cnt > ans) {
                ans = cnt;
            }
        }
        else {
            pair tmp = pairs[now];
            int x = tmp.x;
            int y = tmp.y;
            if(x >= end) {
                bt(pairs, now + 1, cnt + 1, y + 1);
            }
            else {
                bt(pairs, now + 1, cnt, end);
            }
        }
    }
    static class pair {
        int x;
        int y;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean inRange(int x, int y, int len) {
        return x >= 0 && y >= 0 && x < len && y < len;
    }
}


