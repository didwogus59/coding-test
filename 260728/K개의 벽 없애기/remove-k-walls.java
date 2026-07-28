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
        int k = sc.nextInt();
        int[][] map = new int[n][n];
        Deque<pair> deq = new ArrayDeque<>();

        int[][][] visited = new int[n][n][k + 1];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int fstX = sc.nextInt() - 1;
        int fstY = sc.nextInt() - 1;
        int endX = sc.nextInt() - 1;
        int endY = sc.nextInt() - 1;
        deq.add(new pair(fstX, fstY));
        while (!deq.isEmpty()) {
            pair tmp = deq.pop();
            int x = tmp.x;
            int y = tmp.y;
            int cnt = tmp.cnt;
            int now = visited[x][y][cnt];
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(inRange(nx,ny,n,n)) {
                    if(map[nx][ny] == 1) {
                        if(cnt + 1 <= k) {
                            if (visited[nx][ny][cnt + 1] == 0 || visited[nx][ny][cnt + 1] > now + 1) {
                                visited[nx][ny][cnt + 1] = now + 1;
                                deq.add(new pair(nx, ny, cnt + 1));
                            }
                        }
                    }
                    else {
                        if (visited[nx][ny][cnt] == 0 || visited[nx][ny][cnt] > now + 1) {
                            visited[nx][ny][cnt] = now + 1;
                            deq.add(new pair(nx, ny, cnt));
                        }
                    }
                }
            }
        }
        ans = -1;
        for(int i = 0; i <= k; i++) {
            if(visited[endX][endY][i] != 0) {
                if(ans == -1)
                    ans = visited[endX][endY][i];
                else if(visited[endX][endY][i] < ans)
                    ans = visited[endX][endY][i];
            }
        }
        System.out.println(ans);
    }

    static boolean inRange(int x, int y, int lenX, int lenY) {
        return x >= 0 && y >= 0 && x < lenX && y < lenY;
    }
    static class pair {
        int x;
        int y;
        int cnt = 0;
        int now = 0;
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


