import java.util.*;
public class Main {
    static int[] mx = {0, 1, 0, -1};
    static int[] my = {1, 0, -1, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();

        int[][] arr = new int[h][w];
        int t = sc.nextInt();

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                int tmp = sc.nextInt();
                arr[i][j] = tmp;
            }
        }

        for(int i = 0; i < t; i++) {
            int x1 = sc.nextInt() - 1;
            int y1 = sc.nextInt() - 1;
            int x2 = sc.nextInt() - 1;
            int y2 = sc.nextInt() - 1;
            int nx = x1;
            int ny = y1 + 1;
            int move = 0;
            int before = arr[x1][y1];
            while(nx != x1 || ny != y1) {
//                System.out.printf("%d %d\n",nx,ny);
                int tmp = arr[nx][ny];
                arr[nx][ny] = before;
                before = tmp;
                if((nx == x1 && (ny == y1 || ny == y2)) || (nx == x2 && (ny == y1 || ny == y2))) {
                    move += 1;
                }
                nx += mx[move];
                ny += my[move];

            }
            arr[x1][y1] = before;
            int[][] tmp = new int[h][w];
            for(int c = 0; c < h; c++) {
                tmp[c] = arr[c].clone();
            }
            for(int x = x1; x <= x2; x++) {
                for(int y = y1; y <= y2; y++) {
                    tmp[x][y] = mean(arr, h, w, x, y);
                }
            }
            arr = tmp;
        }
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
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