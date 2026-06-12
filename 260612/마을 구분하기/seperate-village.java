import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int ans = 0;
    static int len;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        len = sc.nextInt();
        int[][] visited = new int[len][len];
        int[][] arr = new int[len][len];

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for(int x = 0; x < len; x++) {
            for(int y = 0; y < len; y++) {
                dfs(arr, visited, x, y);
            }
        }
        System.out.println(ans);
        int[] cnt = new int[ans];
        for(int x = 0; x < len; x++) {
            for(int y = 0; y < len; y++) {
                if(visited[x][y] != 0)
                    cnt[visited[x][y] - 1]++;
            }
        }

        Arrays.sort(cnt);
        for(int c : cnt) {
            System.out.println(c);
        }
    }

    static void dfs(int[][] arr, int[][] visited, int x, int y) {
        if(visited[x][y] == 0 && arr[x][y] == 1) {
            ans++;
            visited[x][y] = ans;
            Deque<pair> deq = new ArrayDeque<>();
            deq.add(new pair(x,y));
            while(!deq.isEmpty()) {
                pair p = deq.pop();
                x = p.x;
                y = p.y;

                for(int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(inRange(nx,ny)) {
                        if(visited[nx][ny] == 0 && arr[nx][ny] == 1) {
                            visited[nx][ny] = ans;
                            deq.add(new pair(nx, ny));
                        }
                    }
                }
            }
        }
    }
    static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < len && y < len;
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


