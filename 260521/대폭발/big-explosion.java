import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int cnt = sc.nextInt();
        int px = sc.nextInt() - 1;
        int py = sc.nextInt() - 1;
        int[][] arr = new int[len][len];
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        arr[px][py] = 1;
        int dis = 1;
        for(int i = 0; i < cnt; i++) {
            for(int x = 0; x < len; x++) {
                for(int y = 0; y < len; y++) {
                    if(arr[x][y] <= i + 1 && arr[x][y] != 0) {
                        for (int j = 0; j < 4; j++) {
                            int nx = x + dx[j] * dis;
                            int ny = y + dy[j] * dis;
                            if (inRange(nx, ny, len)) {
                                if(arr[nx][ny] == 0)
                                    arr[nx][ny] = i + 2;
                            }
                        }
                    }
                }
            }
            dis *= 2;
        }
        int ans = 0;
        for(int[] tmpArr : arr) {
            for(int tmp : tmpArr) {
//                System.out.printf("%d ", tmp);
                if(tmp != 0)
                    ans++;
            }
//            System.out.println();
        }
        System.out.println(ans);
    }
    static boolean inRange(int x, int y, int len) {
        return x >= 0 && y >= 0 && x < len && y < len;
    }
}


