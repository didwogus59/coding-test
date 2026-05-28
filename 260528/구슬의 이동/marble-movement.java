import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        Scanner sc = new Scanner(System.in);
        int len = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        Deque<ball> deq = new ArrayDeque<>();
        for(int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            char tmp = st.nextToken().charAt(0);

            int d = 2;
            if(tmp == 'D') {
                d = 0;
            }
            if(tmp == 'L') {
                d = 3;
            }
            if(tmp == 'R') {
                d = 1;
            }
            int v = Integer.parseInt(st.nextToken());
            deq.add(new ball(r,c,d,v,i));
        }
        for(int t = 0; t < time; t++) {
            List<ball>[][] mat = new ArrayList[len][len];
            Deque<ball> tmp = new ArrayDeque<>();
            while(!deq.isEmpty()) {
                ball now = deq.pop();

                int x = now.x;
                int y = now.y;
                int d = now.d;
                int v = now.v;

                v = v % (len * 2 - 2);
                int nx = x + dx[d] * v;
                int ny = y + dy[d] * v;
                while(!inRange(nx, ny, len)) {
                    if(nx < 0)
                        nx = (nx * -1);
                    else if(ny < 0)
                       ny = (ny * -1);
                    else if(nx >= len)
                        nx = len * 2 - nx - 2;
                    else if(ny >= len)
                        ny = len * 2 - ny - 2;
                    d = (d + 2) % 4;
                }

                now.move(nx,ny,d);
                if(mat[nx][ny] == null)
                    mat[nx][ny] = new ArrayList<>();
                mat[nx][ny].add(now);

            }
            for(int x = 0; x < len; x++) {
                for(int y = 0; y < len; y++) {
                    if(mat[x][y] != null) {
                        if(mat[x][y].size() > max){
                            mat[x][y].sort((a, b) -> {
                                if (a.v != b.v)
                                    return b.v - a.v;
                                return b.n - a.n;
                            });
                        }
                        int chk = 0;
                        for(ball b : mat[x][y]) {
                            chk++;
                            tmp.add(b);
//                            System.out.printf("x : %d y: %d  %d %d\n",b.x,b.y,b.n,b.d);
                            if(chk >= max)
                                break;
                        }

                    }
                }
            }
            deq = tmp;
        }
        System.out.println(deq.size());
    }
    static boolean inRange(int x, int y, int len) {
        return x >= 0 && y >= 0 && x < len && y < len;
    }
    static class ball {
        public int x;
        public int y;
        public int d;
        public int v;
        public int n;
        public ball(int x, int y, int d, int v, int n) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.v = v;
            this.n = n;
        }
        public void move(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}


