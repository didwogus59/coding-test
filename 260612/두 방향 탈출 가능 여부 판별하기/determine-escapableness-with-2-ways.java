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
        int m = sc.nextInt();
        int[][] visited = new int[len][m];
        int[][] arr = new int[len][m];

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        Deque<pair> deq = new ArrayDeque<>();
        int cnt = 0;
        int[] dx = {1,0};
        int[] dy = {0,1};
        deq.add(new pair(0,0));
        visited[0][0] = 1;
        while(!deq.isEmpty() && visited[len - 1][m - 1] == 0) {
            pair now = deq.pop();
            int x = now.x;
            int y = now.y;

            for(int i = 0; i < 2; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < len && ny < m) {
                    if (visited[nx][ny] == 0 && arr[nx][ny] == 1) {
                        visited[nx][ny] = 1;
                        deq.push(new pair(nx, ny));
                    }
                }
            }

        }
//        bt(arr, visited, 100000,  0);
        if(visited[len-1][m-1] == 1)
            System.out.println(1);
        else
            System.out.println(0);
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


