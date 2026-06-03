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

        int[] dy = {-1,0,1,0};
        int[] dx = {0,1,0,-1};

        int[][][] mat = new int[2][51][51];
        int[] ballW = new int[2501];
        int[] ballD = new int[2501];
        int[] ballA = new int[2501];
        Deque<ball> deq = new ArrayDeque<>();

        int ans = 0;
        for(int j = 0; j < cnt; j++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            char dir = st.nextToken().charAt(0);
            int w = Integer.parseInt(st.nextToken());

            int d = 3;
            if(dir == 'D') {
                d = 1;
            }
            if(dir == 'L') {
                d = 0;
            }
            if(dir == 'R') {
                d = 2;
            }
            ball now = new ball(x,y,d,j + 1);
            deq.add(now);
            mat[0][x][y] = j + 1;
            ballW[j + 1] = w;
            ballD[j + 1] = d;
            ballA[j + 1] = 1;
        }
        for(int t = 0; t < time; t++) {
            Deque<ball> tmp = new ArrayDeque<>();

            while(!deq.isEmpty()) {
                ball now = deq.pop();

                int x = now.x;
                int y = now.y;

                int n = now.n;
                int w = ballW[n];
                int d = now.d;

//                System.out.printf("%d %d %d\n",x,y, d);
                if(ballA[n] == 0)
                    continue;

                int nx = x + dx[d];
                int ny = y + dy[d];
                if(!inRange(nx,ny,len)) {
                    d = (d + 2) % 4;
                    nx = x;
                    ny = y;
                }
                mat[t%2][x][y] = 0;
                int nextT = (t + 1) % 2;
                int existN = mat[nextT][nx][ny];
                if(existN == 0) {
                    mat[nextT][nx][ny] = n;
                    now.move(nx,ny,d);
                    tmp.add(now);
                }
                else {
                    if(existN > n) {
                        ballW[existN] += w;
                        ballA[n] = 0;
                    }
                    else {
                        ballA[existN] = 0;
                        mat[nextT][nx][ny] = n;
                        ballW[n] += ballW[existN];
                        now.move(nx,ny,d);
                        tmp.add(now);
                    }
                }

            }
//            System.out.printf("\n");
            deq = tmp;
        }
        int ansW = 0;
        int size = 0;
        for(ball b : deq) {
            int n = b.n;
            int w = ballW[n];
            if(ballA[n] == 1)
                size++;
            if(w > ansW)
                ansW = w;
        }
        System.out.printf("%d %d",size,ansW);
    }
    static boolean inRange(int x, int y, int len) {
        return x >= 0 && y >= 0 && x < len && y < len;
    }
    static class ball {
        public int x;
        public int y;
        public int d;
        public int w;
        public int n;
        public ball(int x, int y, int d, int w, int n) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.w = w;
            this.n = n;
        }
        public ball(int x, int y, int d, int n) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.n = n;
        }

        public void move(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}


