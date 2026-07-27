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
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        int[][] visited = new int[n][m];
        for(int x = 0; x < n; x++) {
            for(int y = 0; y < m; y++) {
                arr[x][y] = sc.nextInt();
            }
        }

        Deque<pair> deq = new ArrayDeque<>();
        deq.add(new pair(0,0));
        while (!deq.isEmpty()) {
            pair tmp = deq.pop();
            int x = tmp.x;
            int y = tmp.y;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(inRange(nx,ny,n,m)) {
                    if(arr[nx][ny] == 1) {
                        if (visited[nx][ny] == 0) {
                            visited[nx][ny] = visited[x][y] + 1;
                            deq.add(new pair(nx, ny));
                        } else {
                            if (visited[nx][ny] > visited[x][y] + 1) {
                                visited[nx][ny] = visited[x][y] + 1;
                                deq.add(new pair(nx, ny));
                            }
                        }
                    }
                }
            }

        }
        if(visited[n-1][m-1] == 0)
            visited[n-1][m-1] = -1;
        System.out.println(visited[n-1][m-1]);
    }

    static boolean inRange(int x, int y, int lenX, int lenY) {
        return x >= 0 && y >= 0 && x < lenX && y < lenY;
    }
    static class pair {
        int x;
        int y;
        int cnt = 1;
        int now = 0;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}


