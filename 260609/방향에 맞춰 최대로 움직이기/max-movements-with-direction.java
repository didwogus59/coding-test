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

        int[][] arr = new int[len][len];
        int[][] dir = new int[len][len];

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                dir[i][j] = sc.nextInt() - 1;
            }
        }
        int x = sc.nextInt() - 1;
        int y = sc.nextInt() - 1;
        bt(arr, dir, x, y, 0);
        System.out.println(ans);
    }
    static void bt(int[][] arr,int[][] dir, int x,int y,int cnt) {
        ans = Math.max(ans, cnt);
        int mv = 1;
        int d = dir[x][y];
        int now = arr[x][y];
        int nx = x + mv * dx[d];
        int ny = y + mv * dy[d];

        while(inRange(nx,ny)) {
            if(arr[nx][ny] > arr[x][y]) {
                bt(arr,dir,nx,ny,cnt + 1);
            }
            mv++;
            nx = x + mv * dx[d];
            ny = y + mv * dy[d];
        }
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < len && y < len;
    }
}


