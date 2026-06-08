import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int ans = 0;
    static int max = 0;
    static int[] ori;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int line = sc.nextInt();
        int bridge = sc.nextInt();
        arr = new int[16][line];
        ori = new int[line];
        ans = bridge;
        pair[] pairs = new pair[bridge];
        for(int i = 0; i < bridge; i++) {
            int y = sc.nextInt() - 1;
            int x = sc.nextInt() - 1;
            pairs[i] = new pair(x,y);
            arr[x][y] = 1;
            arr[x][y+1] = -1;
        }
        for(int y = 0; y < line; y++) {
            int now = y;
            for(int x = 0; x < 16; x++) {
                now += arr[x][now];
            }
            ori[y] = now;
        }

        bt(pairs, 0, line, bridge, 0);

        System.out.println(ans);
    }

    static void bt(pair[] pairs, int now, int line, int bridge, int cnt) {
        if(now == bridge) {
            boolean chk = true;
            for(int y = 0; y < line; y++) {
                int n = y;
                for(int x = 0; x < 16; x++) {
                    n += arr[x][n];
                }
                if(ori[y] != n) {
                    chk = false;
                    break;
                }
            }
            if(chk) {
                if(ans > cnt)
                    ans = cnt;
            }
        }
        else {
            pair p = pairs[now];
            int x = p.x;
            int y = p.y;

            arr[x][y] = 0;
            arr[x][y + 1] = 0;
            bt(pairs, now + 1,line, bridge, cnt);

            arr[x][y] = 1;
            arr[x][y + 1] = -1;
            bt(pairs, now + 1,line, bridge, cnt + 1);
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


