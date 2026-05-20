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

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        boolean chk = true;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        while(chk) {
            chk = false;
            int now = arr[x][y];
            System.out.printf("%d ", now);
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= len || ny >= len)
                    continue;
//                System.out.printf("travel %d\n",arr[nx][ny]);
                if(arr[nx][ny] > now) {
                    x = nx;
                    y = ny;
                    chk = true;
                    break;
                }
            }

        }

    }

}


