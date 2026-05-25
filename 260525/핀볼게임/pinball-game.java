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

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        //상하좌우

        int ans = 0;
        for(int x = -1; x < len + 1; x++) {
            for(int y = -1; y < len + 1; y++) {
                if(!inRange(x,y,len)) {
                    for(int i = 0; i < 4; i++) {
                        int nx = x + dx[0][i];
                        int ny = y + dy[0][i];
                        if(inRange(ny,ny,len)) {
                            int tmp = travel(arr, nx,ny, dx[0][i], dy[0][i]);
                            ans = tmp > ans ? tmp : ans;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
    static int travel(int[][] arr, int x, int y,int dirX, int dirY) {
        int cnt = 1;
        int len = arr.length;
        int[][] tmp = new int[len][len];
        while(inRange(x,y,len)) {
            tmp[x][y] = 1;
            if(arr[x][y] != 0) {
                int slash = arr[x][y] - 1;
                int dir = dir(dirX, dirY);
                dirX = dx[slash][dir];
                dirY = dy[slash][dir];
            }
            x = x + dirX;
            y = y + dirY;
            cnt++;
        }
//        for(int[] tmpArr : tmp) {
//            for(int t : tmpArr) {
//                System.out.printf("%d ", t);
//            }
//            System.out.println();
//        }
//        System.out.println();
        return cnt;
    }
    static boolean inRange(int x, int y, int len) {
        return x >= 0 && y >= 0 && x < len && y < len;
    }
    //값 조정 해야함 1 / 2 \
    static int dir(int x, int y) {
        if(x == 0) {
            if(y == 1)
                return 3;
            return 2;
        }
        if(x == 1)
            return 1;
        return 0;
    }
}


