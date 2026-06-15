import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int ans = 0;
    static int cnt = 0;
    static int len;
    static int m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        len = sc.nextInt();
        m = sc.nextInt();
        int[][] arr = new int[len][len];

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int[][] visited = new int[len][len];
        for(int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            if(visited[x][y] == 0)
                dfs(arr, visited, x, y);
        }
        System.out.printf("%d", ans);

    }

    static void dfs(int[][] arr, int[][] visited, int x, int y) {
        Deque<pair> deq = new ArrayDeque<>();
        deq.add(new pair(x,y));
        int size = 0;
        visited[x][y] = 1;
        while(!deq.isEmpty()) {
            pair p = deq.poll();
            x = p.x;
            y = p.y;
            size++;
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(inRange(nx,ny, len, len)) {
                    if(visited[nx][ny] == 0 && arr[nx][ny] == 0) {
                        visited[nx][ny] = 1;
                        deq.add(new pair(nx, ny));
                    }
                }
            }
        }
        ans += size;
    }

    static boolean inRange(int x, int y, int lenX, int lenY) {
        return x >= 0 && y >= 0 && x < lenX && y < lenY;
    }
    static class pair {
        int x;
        int y;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}


