import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int ans = 0;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        int cnt = 0;
        pair[] pairs = new pair[n * n + 1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == 1) {
                    pair now = new pair(i,j);
                    pairs[cnt] = now;
                    cnt++;
                }
            }
        }
        bt(arr, pairs, cnt, 0);
        System.out.println(ans);
    }

    static void bt(int[][] arr, pair[] pairs, int now, int next) {
        if(pairs[next] == null) {
//            for(int[] tmpArr : arr) {
//                for(int i : tmpArr) {
//                    System.out.printf("%d ",i);
//                }
//                System.out.println();
//            }
//
//            System.out.println();
            if(now > ans) {
                ans = now;
            }
        }
        else {
            pair tmp = pairs[next];
            int x = tmp.x;
            int y = tmp.y;
            for(int i = 0; i < 3; i++) {
                int boomNow = boom(arr,x,y,i);
                bt(arr, pairs,now + boomNow, next + 1);
                clear(arr,x,y,i);
            }
        }
    }
    static class pair {
        int x;
        int y;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int boom(int[][] arr, int x, int y, int t) {
        int boom = 0;
        int[][] dx = {{1,2,-1,-2},{1,-1,0,0},{1,1,-1,-1}};
        int[][] dy = {{0,0,0,0},{0,0,-1,1},{1,-1,1,-1}};
        int len = arr.length;
        for(int i = 0; i < 4; i++) {
            int nx = dx[t][i] + x;
            int ny = dy[t][i] + y;
            if(inRange(nx,ny,len)) {
                if(arr[nx][ny] == 0) {
                    boom += 1;
                }
                arr[nx][ny] += 1;
            }
        }
        return boom;
    }
    static void clear(int[][] arr, int x, int y, int t) {
        int[][] dx = {{1,2,-1,-2},{1,-1,0,0},{1,1,-1,-1}};
        int[][] dy = {{0,0,0,0},{0,0,-1,1},{1,-1,1,-1}};
        int len = arr.length;
        for(int i = 0; i < 4; i++) {
            int nx = dx[t][i] + x;
            int ny = dy[t][i] + y;
            if(inRange(nx,ny,len)) {
                arr[nx][ny] -= 1;
            }
        }
    }

    static boolean inRange(int x, int y, int len) {
        return x >= 0 && y >= 0 && x < len && y < len;
    }
}


