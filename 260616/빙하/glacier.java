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
        Deque<pair> deq = new ArrayDeque<>();

        int[][][] arr = new int[2][len][m];
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < m; j++) {
                arr[0][i][j] = sc.nextInt();
                if(arr[0][i][j] == 1) {
                    deq.add(new pair(i,j));
                }
            }
        }

        int time = 0;
        int size = 0;


        while(true) {
            int now = time % 2;
            int nxt = (time + 1) % 2;

            int[][] surround = new int[len][m];
            surround[0][0] = 1;
            Deque<pair> wt = new ArrayDeque<>();

            wt.add(new pair(0,0));
            while(!wt.isEmpty()) {
                pair p = wt.pop();
                int x = p.x;
                int y = p.y;
                for(int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(inRange(nx,ny,len,m)) {
                        if(arr[now][nx][ny] == 0 && surround[nx][ny] == 0) {
                            surround[nx][ny] = 1;
                            wt.add(new pair(nx,ny));
                        }
                    }
                }
            }
            Deque<pair> tmp = new ArrayDeque<>();
            size = deq.size();
//            for(int i = 0; i < len; i++) {
//                for(int j = 0; j < m; j++) {
//                    System.out.printf("%d ",arr[now][i][j]);
//                }
//                System.out.println();
//            }
            while (!deq.isEmpty()) {
                pair p = deq.pop();
                int x = p.x;
                int y = p.y;
                boolean chk = true;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (inRange(nx, ny, len, m)) {
                        if(arr[now][nx][ny] == 0 && surround[nx][ny] == 1) {
                            chk = false;
                            break;
                        }
                    }
                }
                if(chk) {
                    arr[nxt][x][y] = 1;
                    tmp.add(new pair(x, y));
                }
            }
            deq = tmp;
            arr[now] = new int[len][m];
            time++;

            if(deq.isEmpty()) {
                break;
            }
        }
        System.out.printf("%d %d",time, size);
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


