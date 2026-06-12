import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int ans = Integer.MIN_VALUE;
    static int len;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        len = sc.nextInt();

        int[] visited = new int[len];
        int[][] arr = new int[len][len];

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        bt(arr, visited, 100000,  0);

        System.out.println(ans);
    }
    static void bt(int[][] arr, int[] visited, int now, int cnt) {
            if (cnt == len) {
                ans = Math.max(ans,now);
            }
            else {
                for(int i = 0; i < len; i++) {
                    if(visited[i] == 0) {
                        visited[i] = 1;
                        bt(arr, visited, Math.min(now, arr[cnt][i]),cnt + 1);
                        visited[i] = 0;
                    }
                }
            }
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < len && y < len;
    }
    static int dis(pair p1, pair p2) {
        int dx = p1.x - p2.x;
        int dy = p1.y - p2.y;
        return dx * dx + dy * dy;
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


