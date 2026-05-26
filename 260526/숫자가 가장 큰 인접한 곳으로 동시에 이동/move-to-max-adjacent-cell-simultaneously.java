import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int[][] dx = {{0,0,1,-1},{0,0,-1,1}};
    static int[][] dy = {{1,-1,0,0},{-1,1,0,0}};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[][] arr= new int[len][len];

        int cnt = sc.nextInt();

        int time = sc.nextInt();
        
        for(int x = 0; x < len; x++) {
            for(int y = 0; y < len; y++) {
                arr[x][y] = sc.nextInt();
            }
        }
        int[][] ball = new int[len][len];

        for(int i = 0; i < cnt; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            ball[x][y] = 1;
        }
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        int ans = cnt;

        for(int i = 0; i < time; i++) {
            int[][] tmp = new int[len][len];
            for(int x = 0; x < len; x++) {
                for(int y = 0; y < len; y++) {
                    if(ball[x][y] == 1) {
                        int max = -1;
                        int max_d = 0;
                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];
                            if (inRange(nx, ny, len)) {
                                if (arr[nx][ny] > max) {
                                    max_d = d;
                                    max = arr[nx][ny];
                                }
                            }
                        }
                        int nx = x + dx[max_d];
                        int ny = y + dy[max_d];
                        tmp[nx][ny] += 1;
                    }
                }
            }
            ans = 0;
            for(int x = 0; x < len; x++) {
                for(int y = 0; y < len; y++) {
                    if(tmp[x][y] == 1) {
                        ball[x][y] = 1;
                        ans++;
                    }
                    else {
                        ball[x][y] = 0;
                    }
                }
            }
        }
        System.out.println(ans);
    }
    static boolean inRange(int x, int y, int len) {
        return x >= 0 && y >= 0 && x < len && y < len;
    }
}


