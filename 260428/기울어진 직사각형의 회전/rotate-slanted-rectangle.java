import java.util.*;
public class Main {
    static int[] mx = {0, 1, 0, -1};
    static int[] my = {1, 0, -1, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();

        int[][] arr = new int[h][h];

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < h; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int x = sc.nextInt() - 1;
        int y = sc.nextInt() - 1;
        int[] dis = new int[4];
        for(int i = 0; i < 4; i++) {
            dis[i] = sc.nextInt();
        }
        int dir = sc.nextInt();
        if(dir == 1) {
            int[] tmp = new int[4];
            for(int i = 0; i < 4; i++) {
                tmp[3 - i] = dis[i];
            }
            dis = tmp;
        }
        int[][] mx = {{-1,-1,1,1},{-1,-1,1,1}};
        int[][] my = {{1,-1,-1,1},{-1,1,1,-1}};
        int before = arr[x][y];
        int nx = x;
        int ny = y;
        for(int i = 0; i < 4; i++) {
            for(int d = 0; d < dis[i]; d++) {
//                System.out.printf("%d %d\n",nx,ny);
                nx += mx[dir][i];
                ny += my[dir][i];
                int tmp = arr[nx][ny];
                arr[nx][ny] = before;
                before = tmp;
            }
        }
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < h; j++) {
                System.out.printf("%d ",arr[i][j]);
            }
            System.out.println();
        }


    }
    static int mean(int[][] arr, int h, int w, int x, int y) {
        int count = 1;
        int sum = arr[x][y];

        for(int i = 0; i < 4; i++) {
            int nx = x + mx[i];
            int ny = y + my[i];
            if(inRange(h,w,nx,ny)) {
                sum += arr[nx][ny];
                count++;
            }
        }
        return sum / count;
    }
    static boolean inRange(int h, int w, int x, int y) {
        return x >= 0 && y >= 0 && x < h && y < w;
    }
}
/*

5
1 2 2 2 2
1 3 4 4 4
1 2 3 3 3
1 2 3 3 3
1 2 3 3 3
4 2 2 1 2 1 0

*/
