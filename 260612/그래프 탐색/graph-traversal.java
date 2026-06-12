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
        int[] visited = new int[len + 1];
        int[][] arr = new int[len + 1][len + 1];

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        Deque<Integer> deq = new ArrayDeque<>();
        int cnt = 0;
        deq.add(1);
        visited[1] = 1;
        while(!deq.isEmpty()) {
            int now = deq.pop();
            for (int i = 1; i <= len; i++) {
                if (arr[now][i] == 1 && visited[i] == 0) {
                    visited[i] = 1;
                    cnt += 1;
                    deq.add(i);
                }
            }

        }
//        bt(arr, visited, 100000,  0);

        System.out.println(cnt);
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


