import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int ans = Integer.MAX_VALUE;
    static int len;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        len = sc.nextInt();
        int[] arrX = new int[10];
        int[] arrY = new int[10];
        for(int i = 0; i < 10; i++) {
            arrX[i] = -1;
        }
        int sx = 0, sy = 0;
        int ex = 0, ey = 0;
        for(int i = 0; i < len; i++) {
            String tmp = sc.next();
            for(int j = 0; j < len; j++) {
                char c = tmp.charAt(j);
                if(c == 'S') {
                   sx = i;
                   sy = j;
                }
                else if(c == 'E') {
                    ex = i;
                    ey = j;
                } else if (c != '.') {
                    int num = c - '1' + 1;
                    arrX[num] = i;
                    arrY[num] = j;
                }
            }
        }
        bt(arrX, arrY, sx, sy,0, 0, 0, ex, ey);
        if(ans == Integer.MAX_VALUE)
            ans = -1;
        System.out.println(ans);
    }
    static void bt(int[] arrX, int[] arrY, int x, int y,int now, int sum, int cnt, int ex, int ey) {
        if(sum < ans) {
            if (cnt == 3) {
                int ed = dis(x,y,ex,ey);
                ans = Math.min(sum + ed, ans);
            } else {
                for (int i = now + 1; i < 10; i++) {
                    if(arrX[i] != -1) {
                        int nx = arrX[i];
                        int ny = arrY[i];
                        bt(arrX, arrY, nx, ny, i, sum + dis(x, y, nx, ny), cnt + 1, ex, ey);
                    }
                }
            }
        }
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < len && y < len;
    }

    static int dis(int x, int y, int nx, int ny) {
        int dx = nx - x;
        int dy = ny - y;
        dx = dx > 0 ? dx : (dx * -1);
        dy = dy > 0 ? dy : (dy * -1);
        return dx + dy;
    }

    static class pair {
        public int x;
        public int y;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}


