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
        int[][] vst = new int[n][n];
        Deque<pair> deq = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 2) {
                    deq.add(new pair(i,j));
                    vst[i][j] = 1;
                }
                if(map[i][j] == 1) {
                    vst[i][j] = -1;
                }
            }
        }

        while (!deq.isEmpty()) {
            pair tmp = deq.pop();
            int x = tmp.x;
            int y = tmp.y;
            int now = vst[x][y];
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(inRange(nx, ny, n, n)) {
                    if(map[nx][ny] == 1) {
                        if(vst[nx][ny] == 0 || vst[nx][ny] == -1 || vst[nx][ny] > now + 1) {
                            vst[nx][ny] = now + 1;
                            deq.add(new pair(nx, ny));
                        }
                    }
                }
            }
        }
        for(int[] tmpArr : vst) {
            for(int tmp : tmpArr) {
                System.out.printf("%d ", tmp - 1);
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


