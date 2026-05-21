import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int cnt = sc.nextInt();
        int x = sc.nextInt() - 1;
        int y = sc.nextInt() - 1;
        int[][] arr = new int[len][len];

        sc.nextLine();
        String dir = sc.nextLine();
        String[] dirs = dir.split(" ");

        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};

        int now = 6;
        int[] dice = {3,4,5,2};
        arr[x][y] = 6;
        for(int i = 0; i < cnt; i++) {
            int l = 1;
            if("R".equals(dirs[i])) {
                l = 0;
            }
            if("U".equals(dirs[i])) {
                l = 2;
            }
            if("D".equals(dirs[i])) {
                l = 3;
            }
            int nx = x + dx[l];
            int ny = y + dy[l];
            if(nx >= 0 && ny >= 0 && nx < len && ny < len) {
                int tmp = now;
                now = dice[l];
                x = nx;
                y = ny;
                arr[x][y] = now;
                dice[l] = 7 - tmp;
                if(l == 0) {
                    dice[1] = tmp;
                }
                if(l == 1) {
                    dice[0] = tmp;
                }
                if(l == 2) {
                    dice[3] = tmp;
                }
                if(l == 3) {
                    dice[2] = tmp;
                }

            }
        }
        int ans = 0;
        for(int[] tmpArr : arr) {
            for(int tmp : tmpArr) {
//                System.out.printf("%d ", tmp);
                ans += tmp;
            }
//            System.out.println();
        }

        System.out.println(ans);
    }

}


