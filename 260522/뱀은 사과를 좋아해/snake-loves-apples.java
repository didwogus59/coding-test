import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int apple = sc.nextInt();
        int move = sc.nextInt();
        int[][] arr= new int[len][len];

        Deque<Integer> sx = new ArrayDeque<>();
        Deque<Integer> sy = new ArrayDeque<>();

        sx.offerFirst(0);
        sy.offerFirst(0);
        arr[0][0] = 2;
        for(int i = 0; i < apple; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            arr[x][y] = 1;
        }
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int ans = 0;
        for(int i = 0; i < move; i++) {
            String tmp = sc.next();
            boolean chk = false;
            int dir = 0;
            if("L".equals(tmp)) {
                dir = 1;
            }
            if("D".equals(tmp)) {
                dir = 2;
            }
            if("U".equals(tmp)) {
                dir = 3;
            }
            int dis = sc.nextInt();
            int x = sx.peekFirst();
            int y = sy.peekFirst();

            for(int d = 0; d < dis; d++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                ans++;
                if(inRange(nx,ny,len)) {
                    x = nx;
                    y = ny;
                    if(arr[x][y] != 1) {
                        int rx = sx.pollLast();
                        int ry = sy.pollLast();
                        arr[rx][ry] = 0;
                    }
                    if(arr[x][y] == 2) {
                        chk = true;
                        break;
                    }
                    sx.offerFirst(x);
                    sy.offerFirst(y);
                    arr[x][y] = 2;
                }
                else {
                    chk = true;
                    break;
                }
//                for(int[] tmpArr : arr) {
//                    for(int tmp1 : tmpArr) {
//                        System.out.printf("%d ", tmp1);
//                    }
//                    System.out.println();
//                }
//
//                System.out.println();
            }
            if(chk)
                break;
        }
        System.out.println(ans);
    }
    static boolean inRange(int x, int y, int len) {
        return x >= 0 && y >= 0 && x < len && y < len;
    }
}


