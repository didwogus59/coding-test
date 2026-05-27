import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int cnt = sc.nextInt();
        int[] numX = new int[500];
        int[] numY = new int[500];

        Deque<Integer>[][] arr = new ArrayDeque[len][len];
        int[][] maxNum = new int[len][len];
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                int tmp = sc.nextInt();
                arr[i][j] = new ArrayDeque<Integer>();
                arr[i][j].add(tmp);
                numX[tmp] = i;
                numY[tmp] = j;
                maxNum[i][j] = tmp;
            }
        }
        int[] dx = {0,0,1,-1,1,1,-1,-1};
        int[] dy = {1,-1,0,0,-1,1,-1,1};
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < cnt; i++) {
            int n = sc.nextInt();

            int x = numX[n];
            int y = numY[n];
            int now = arr[x][y].pop();
            stack.push(now);
            while(now != n) {
                now = arr[x][y].pop();
                stack.push(now);
            }
            int nx = x;
            int ny = y;
            int max = 0;
            for(int m = 0; m < 8; m++) {
                int tmpX = x + dx[m];
                int tmpY = y + dy[m];
                if(inRange(tmpX, tmpY, len)) {
                    if(maxNum[tmpX][tmpY] > max) {
                        nx = tmpX;
                        ny = tmpY;
                        max = maxNum[tmpX][tmpY];
                    }
                }
            }
            while(!stack.isEmpty()) {
                now = stack.pop();
                arr[nx][ny].push(now);
                numX[now] = nx;
                numY[now] = ny;
                if(max < now) {
                    maxNum[nx][ny] = now;
                    max = now;
                }
            }
            max = 0;
            for(int num : arr[x][y]) {
                if(num > max) {
                    max = num;
                }
            }

            maxNum[x][y] = max;
        }
        for(int x = 0; x < len; x++) {
            for(int y = 0; y < len; y++) {
                if(arr[x][y].isEmpty()) {
                    System.out.println("None");
                }
                else {
                    while(!arr[x][y].isEmpty()) {
                        System.out.printf("%d ",arr[x][y].poll());
                    }
                    System.out.println();
                }
            }
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


