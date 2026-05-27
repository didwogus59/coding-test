import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int time = Integer.parseInt(st.nextToken());

        int[][] tmp = new int[51][51];

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        for(int i = 0; i < time; i++) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());

            int ball = Integer.parseInt(st.nextToken());

            Deque<ball> deq = new ArrayDeque<>();


            for(int cnt = 0; cnt < ball; cnt++) {
                st = new StringTokenizer(br.readLine());
                  int x = Integer.parseInt(st.nextToken()) - 1;
                  int y = Integer.parseInt(st.nextToken()) - 1;
                  String dir = st.nextToken();
                  int d = 0;
                  if('D' == dir.charAt(0))
                      d = 2;
                  if('R' == dir.charAt(0))
                      d = 3;
                  if('L' == dir.charAt(0))
                      d = 1;
                  deq.add(new ball(x,y,d));
            }
            for (int m = 0; m < len * 2 + 1; m++) {
                int cnt = deq.size();

                for(int j = 0; j < cnt; j++) {
                    ball b = deq.pop();
                    int x = b.x;
                    int y = b.y;
                    int d = b.d;

                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if(!inRange(nx,ny,len)) {
                        nx = x;
                        ny = y;
                        d = (d + 2) % 4;
                    }

                    tmp[nx][ny] += 1;
                    b.move(nx,ny,d);
                    deq.add(b);
                }

                for(int j = 0; j < cnt; j++) {
                    ball b = deq.pop();
                    int x = b.x;
                    int y = b.y;
                    int d = b.d;

                    if(tmp[x][y] == 1) {
                        b.move(x,y,d);
                        deq.add(b);
                    }
                    tmp[x][y] = 0;
                }
            }
            StringBuffer sb = new StringBuffer();
            sb.append(deq.size()).append('\n');
            System.out.print(sb);
        }
    }
    static boolean inRange(int x, int y, int len) {
        return x >= 0 && y >= 0 && x < len && y < len;
    }
    static class ball {
        public int x;
        public int y;
        public int d;

        public ball(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
        public void move(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}


