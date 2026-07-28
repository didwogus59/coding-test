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
        int h = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][n];
        Deque<pair> deq = new ArrayDeque<>();

        int[][] visited = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int tmp = sc.nextInt();
                map[i][j] = tmp;
                if(tmp == 3) {
                    deq.add(new pair(i,j));
                    visited[i][j] = 1;
                }
            }
        }

        while (!deq.isEmpty()) {
            pair tmp = deq.pop();
            int x = tmp.x;
            int y = tmp.y;
            int now = visited[x][y];
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(inRange(nx,ny,n,n)) {
                    if(map[nx][ny] != 1) {
                        if (visited[nx][ny] == 0 || visited[nx][ny] > now + 1) {
                            visited[nx][ny] = now + 1;
                            deq.add(new pair(nx, ny));
                        }
                    }
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 2) {
                    if(visited[i][j] == 0) {
                        System.out.print("-1 ");
                    }
                    else {
                        System.out.printf("%d ", visited[i][j] - 1);
                    }
                }
                else {
                    System.out.printf("%d ", 0);
                }
            }
            System.out.println();
        }
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


