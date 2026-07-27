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

        int u = sc.nextInt();
        int d = sc.nextInt();

        int[][] visited = new int[len][len];
        int[][] arr = new int[len][len];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            list.add(0);
        }
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int city = 0;
        Deque<pair> deq = new ArrayDeque<>();
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {

                if(visited[i][j] == 0) {
                    int cnt = 1;
                    city++;
                    visited[i][j] = city;
                    deq.add(new pair(i, j));
                    while (!deq.isEmpty()) {
                        pair p = deq.pop();
                        int x = p.x;
                        int y = p.y;
                        int now = arr[x][y];
                        for(int m = 0; m < 4; m++) {
                            int nx = x + dx[m];
                            int ny = y + dy[m];
                            if(inRange(nx,ny,len,len)) {
                                if(visited[nx][ny] == 0) {
                                    int nxt = arr[nx][ny];
                                    int gap = now - nxt > 0 ? now - nxt : nxt - now;
                                    if(gap >= u && gap <= d) {
//                                        System.out.printf("x %d y %d nx %d ny %d gap %d\n",x,y,nx,ny,gap);
                                        visited[nx][ny] = city;
                                        deq.add(new pair(nx,ny));
                                        cnt += 1;
                                    }
                                }
                            }
                        }
                    }
                    list.add(cnt);
                }
            }
        }
        Collections.sort(list, (a, b) -> {
            return b - a;
        });

        for(int i = 0; i < m; i++) {
            ans += list.get(i);
        }
        System.out.println(ans);
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


