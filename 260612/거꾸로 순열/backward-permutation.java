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

        int[] visited = new int[len + 1];
        StringBuilder sb = new StringBuilder();
        bt(visited, sb, 0);
    }
    static void bt(int[] visited, StringBuilder now, int cnt) {
            if (cnt == len) {
                System.out.println(now);
            }
            else {
                for(int i = len; i > 0; i--) {
                    if(visited[i] == 0) {
                        StringBuilder tmp = new StringBuilder();
                        tmp.append(now);
                        tmp.append(i);
                        tmp.append(" ");
                        visited[i] = 1;
                        bt(visited, tmp, cnt + 1);
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


