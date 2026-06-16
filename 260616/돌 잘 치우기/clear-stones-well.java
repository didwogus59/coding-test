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
        len = sc.nextInt();
        m = sc.nextInt();
        int w = sc.nextInt();

        int[][] arr = new int[len][len];

        int[] wallX = new int[10];
        int[] wallY = new int[10];
        int wallCnt = 0;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == 1) {
                    wallX[wallCnt] = i;
                    wallY[wallCnt] = j;
                    wallCnt++;
                }
            }
        }

        Deque<pair> deq = new ArrayDeque<>();
        for(int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            deq.add(new pair(x,y));
        }
        breakWall(deq, arr, wallX, wallY,0,0,wallCnt, w);
        System.out.println(ans);
    }
    static void dfs(Deque<pair> deq, int[] wallX, int[] wallY, int[][] arr, int w) {

        int[][] visited = new int[len][len];
        int size = 0;

        Deque<pair> tmp = new ArrayDeque<>();
        for(pair p : deq) {
            tmp.add(p);
            visited[p.x][p.y] = 1;
            size++;
        }
        while(!tmp.isEmpty()) {
            pair p = tmp.pop();
            int x = p.x;
            int y = p.y;
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(inRange(nx,ny,len,len)) {
                    if(arr[nx][ny] == 0 && visited[nx][ny] == 0) {
                        size++;
                        visited[nx][ny] = 1;
                        tmp.add(new pair(nx,ny));
                    }
                }
            }
        }
        ans = Math.max(size, ans);
    }
    static void breakWall(Deque<pair> deq, int[][] arr, int[] wallX, int[] wallY,int now, int cnt,int wallCnt, int w) {
        if(cnt == w) {
            dfs(deq, wallX, wallY, arr, w);
        }
        else {
            for(int i = now; i < wallCnt; i++) {
                int x = wallX[i];
                int y = wallY[i];
                arr[x][y] = 0;
                breakWall(deq, arr, wallX, wallY, i + 1, cnt + 1, wallCnt, w);
                arr[x][y] = 1;
            }
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


