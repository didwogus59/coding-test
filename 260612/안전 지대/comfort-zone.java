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
        int m = sc.nextInt();

        int[][] arr = new int[len][m];
        int max = 0;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
                max = Math.max(max, arr[i][j]);
            }
        }
        int ansH = 1;
        for(int h = max; h >= 1; h--) {
            int tmp = dfs(arr,m, h);
            if(tmp >= ans) {
                ans = tmp;
                ansH = h;
            }
        }
        System.out.printf("%d %d",ansH,ans);

    }

    static int dfs(int[][] arr,int m, int h) {
        int[][] visited = new int[len][m];
        int cnt = 0;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < m; j++) {
                if(visited[i][j] == 0 && arr[i][j] > h) {
                    cnt++;
                    Deque<pair> deq = new ArrayDeque<>();

                    deq.add(new pair(i,j));
                    while(!deq.isEmpty()) {
                        pair p = deq.pop();
                        int x = p.x;
                        int y = p.y;

                        for(int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];

                            if(nx >= 0 && ny >= 0 && nx < len && ny < m) {
                                if(visited[nx][ny] == 0 && arr[nx][ny] > h) {
                                    deq.add(new pair(nx,ny));
                                    visited[nx][ny] = 1;
                                }
                            }
                        }
                    }
                }
            }
        }
//        System.out.printf("now %d %d\n",cnt,h);
        return cnt;
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


