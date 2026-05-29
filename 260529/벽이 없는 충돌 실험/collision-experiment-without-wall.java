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
        int cnt = Integer.parseInt(st.nextToken());

        int[] dy = {-1,0,1,0};
        int[] dx = {0,1,0,-1};

        int[][] mat = new int[4001][4001];
        int[] ballW = new int[101];
        int[] ballT = new int[101];
        int[] ballA = new int[101];

        for(int i = 0; i < cnt; i++) {

            Deque<ball> deq = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            int balls = Integer.parseInt(st.nextToken());
            for(int j = 0; j < balls; j++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken()) * 2 + 2000;
                int x = Integer.parseInt(st.nextToken()) * 2 + 2000;
                int w = Integer.parseInt(st.nextToken());

                char dir = st.nextToken().charAt(0);

                int d = 1;
                if(dir == 'D') {
                    d = 3;
                }
                if(dir == 'L') {
                    d = 0;
                }
                if(dir == 'R') {
                    d = 2;
                }
                ball b = new ball(x,y,d,w,j + 1);
                ballW[j + 1] = w;
                ballA[j + 1] = 1;
                ballT[j + 1] = 0;
                mat[x][y] = j + 1;
                deq.add(b);
            }
            List<Integer> bump = new ArrayList<>();
            for(ball b1 : deq) {
                for(ball b2 : deq) {
                    if(b1.n < b2.n) {
                        if(b1.x == b2.x) {
                            if((b1.d == 0 && b2.d == 2) || (b1.d == 2 && b2.d == 0)) {
                                int tmp = b1.y - b2.y;
                                int time = tmp > 0 ? tmp : tmp * -1;
                                bump.add(time / 2);
                            }
                        }
                        else if(b1.y == b2.y) {
                            if((b1.d == 3 && b2.d == 1) || (b1.d == 1 && b2.d == 3)) {
                                int tmp = b1.x - b2.x;
                                int time = tmp > 0 ? tmp : tmp * -1;
                                bump.add(time / 2);
                            }
                        }
                        //(x1 - x2) * (dy2 - dy1)  = (dx2 - dx1) * (y1 - y2)
                        else if((b1.x - b2.x) * (dy[b2.d] - dy[b1.d]) == (dx[b2.d] - dx[b1.d]) * (b1.y-b2.y)) {
                            int time = 0;
                            if((dx[b2.d] - dx[b1.d]) != 0)
                                time = ((b1.x-b2.x) / (dx[b2.d] - dx[b1.d]));
                            else if(dy[b2.d] - dy[b1.d] != 0)
                                time = ((b1.y-b2.y) / (dy[b2.d] - dy[b1.d]));
                            if(time != 0) {
                                int tmp = time > 0 ? time : time * -1;
                                bump.add(tmp);
                            }
                        }
                    }
                }
                bump.add(5000);
            }
            Collections.sort(bump);
            int ans = -1;
            int bef = 0;
            for(int time : bump) {
                if(bef == time)
                    continue;
                int t = time - bef;
                bef = time;
                Deque<ball> tmp = new ArrayDeque<>();
                if(deq.isEmpty() || deq.size() == 1) {
                    break;
                }
                while(!deq.isEmpty()) {
                    ball now = deq.pop();
                    int x = now.x;
                    int y = now.y;
                    int w = now.w;
                    int d = now.d;
                    int n = now.n;
                    if(ballA[n] != 1)
                        continue;
                    int nx = x + dx[d] * t;
                    int ny = y + dy[d] * t;
                    if(mat[x][y] == n)
                        mat[x][y] = 0;
                    ballT[n] = time;
                    if(!inRange(nx,ny,4001)) {
                        ballA[n] = 0;
                        continue;
                    }
                    int exist = mat[nx][ny];
                    if(exist == 0 || ballT[exist] != time) {
                        mat[nx][ny] = n;
                        now.move(nx,ny,d);
                        tmp.add(now);
                    }
                    else {
                        ans = time;

                        if( (ballW[exist] < w) || (ballW[exist]  == w && exist < n) ) {
                            ballA[exist] = 0;
                            mat[nx][ny] = n;
                            now.move(nx,ny,d);
                            tmp.add(now);
                            ballT[n] = time;
                        }
                    }
                }
                deq = tmp;
            }
            System.out.printf("%d\n",ans);
        }

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
        public void move(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}


