import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int ans = 0;
    static int[][] arr;
    static int[][] max;
    static int len;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        len = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();
        arr = new int[len][len];
        max = new int[len][len];
        ans = 0;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < len * len; i++) {
            int x = i / len;
            int y = i % len;
            btMax(x,y,0,0,0,m,c);
        }
        int bef = 0;
        for(int y = 0; y <= len - m; y++) {
            bef = Math.max(bef, max[0][y]);
        }
        for(int x = 1; x < len; x++) {
            int now = max[x][0];
            for(int y = 1; y <= len - m; y++) {
                now = Math.max(now, max[x][y]);
            }
            if(ans < bef + now) {
                ans = bef + now;
                bef = Math.max(bef, now);
            }
        }
        for(int x = 0; x < len; x++) {
            for(int y1 = 0; y1 < len - m; y1++) {
                for(int y2 = y1 + m; y2 <= len - m; y2++) {
                    if(max[x][y1] + max[x][y2] > ans) {
                        ans = max[x][y1] + max[x][y2];
                    }
                }
            }
        }
        System.out.println(ans);
    }

    static void btMax(int x, int y, int sum, int sumS, int now, int cnt, int c) {
        if(now == cnt) {
            if(sumS > max[x][y - cnt])
                max[x][y - cnt] = sumS;
        }
        else {
            if(y < len) {
                if(sum + arr[x][y] <= c) {
                    btMax(x,y + 1,sum + arr[x][y], sumS + arr[x][y] * arr[x][y], now + 1, cnt, c);
                }
                btMax(x,y + 1,sum, sumS, now + 1, cnt, c);
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


