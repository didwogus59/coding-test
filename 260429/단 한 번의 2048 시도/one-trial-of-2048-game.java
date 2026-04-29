import java.util.*;
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int[][] arr = new int[4][4];

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        String tmp = sc.next();
        char dirC = tmp.charAt(0);
        int dir;
        if(dirC == 'U')
            dir = 0;
        else if(dirC == 'D') {
            dir = 1;
        }
        else if(dirC == 'L') {
            dir = 2;
        }
        else {
            dir = 3;
        }
        int[] dirX = {0,0,1,1};
        int[] dirY = {1,1,0,0};
        int[] moveX = {1,-1,0,0};
        int[] moveY = {0,0,1,-1};
        int[] initX = {0, 3, 0, 0};
        int[] initY = {0, 0, 0, 3};
        for(int line = 0; line < 4; line++) {
            int x = line * dirX[dir] + initX[dir];
            int y = line * dirY[dir] + initY[dir];

            int bx = x;
            int by = y;
            int bef = arr[x][y];
            for(int m = 0; m < 3; m++) {
                x = x + moveX[dir];
                y = y + moveY[dir];
                if(arr[x][y] == bef) {
//                    System.out.printf("%d %d\n",nx,ny);
                    arr[x][y] = 0;
                    arr[bx][by] *= 2;
                }
                bef = arr[x][y];
                bx = x;
                by = y;
            }
        }
        for(int line = 0; line < 4; line++) {
            for(int cnt = 0; cnt < 3; cnt++) {
                int x = line * dirX[dir] + initX[dir];
                int y = line * dirY[dir] + initY[dir];

                int bx = x;
                int by = y;
                int bef = arr[x][y];
                for (int m = 0; m < 3; m++) {
                    x = x + moveX[dir];
                    y = y + moveY[dir];
                    if (bef == 0) {
                        arr[bx][by] = arr[x][y];
                        arr[x][y] = 0;
                    }
                    bef = arr[x][y];
                    bx = x;
                    by = y;
                }
            }
        }
        for(int[] i : arr) {
            for(int j : i) {
                System.out.printf("%d ",j);
            }
            System.out.println();
        }
    }
}
