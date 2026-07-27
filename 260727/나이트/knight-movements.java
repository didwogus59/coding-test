import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int ans = 0;
    static int len;
    static int m;
    static int[] dx = {-2, 2, -2, 2,1, 1, -1, -1};
    static int[] dy = {1, 1, -1, -1,-2, 2, -2, 2};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int fstX = sc.nextInt() - 1;
        int fstY = sc.nextInt() - 1;
        int desX = sc.nextInt() - 1;
        int desY = sc.nextInt() - 1;
        int[][] visited = new int[n][n];
        visited[desX][desY] = -1;
        visited[fstX][fstY] = 0;
        Deque<pair> deq = new ArrayDeque<>();
        deq.add(new pair(fstX,fstY));
        while (!deq.isEmpty()) {
            pair tmp = deq.pop();
            int x = tmp.x;
            int y = tmp.y;

            for(int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(inRange(nx,ny,n,n)) {
                    if(nx == desX && ny == desY) {
                        if(visited[desX][desY] == -1) {
                            visited[desX][desY] = visited[x][y] + 1;
                        }
                        if(visited[desX][desY] > visited[x][y] + 1) {
                            visited[desX][desY] = visited[x][y] + 1;
                        }
                    }
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

        System.out.println(visited[desX][desY]);
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


