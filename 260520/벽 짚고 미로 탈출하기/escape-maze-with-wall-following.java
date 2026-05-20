import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int x = sc.nextInt() - 1;
        int y = sc.nextInt() - 1;

        int[][] arr = new int[len][len];
        sc.nextLine();
        for(int i = 0; i < len; i++) {
            String tmp = sc.nextLine();
            for(int j = 0; j < len; j++) {
                arr[i][j] = 0;
                if(tmp.charAt(j) == '#') {
                    arr[i][j] = 1;
                }
            }
        }

        int cnt = 0;
        int[] dx = {0,-1,0,1};
        int[] dy = {1,0,-1,0};
        int[] lx = {1,0,-1,0};
        int[] ly = {0,1,0,-1};
        int now = 0;
        int loop = 0;
        while(cnt < len * len * 3 && loop < 4) {
            cnt++;
            int nx = x + dx[now];
            int ny = y + dy[now];
            if(nx < 0 || ny < 0 || nx >= len || ny >= len) {
                break;
            }
            int blockX = nx + lx[now];
            int blockY = ny + ly[now];
            if (arr[nx][ny] == 0) {
                if (arr[blockX][blockY] == 1) {
                    x = nx;
                    y = ny;
                } else {
                    x = blockX;
                    y = blockY;
                    now = (now + 3) % 4;
                    cnt++;
                }
                loop = 0;
            }
            else {
                cnt--;
                now = (now + 1) % 4;
                loop++;
            }
        }
        if(cnt >= len * len * 3 || loop == 4)
            cnt = -1;
        System.out.println(cnt);


    }

}


