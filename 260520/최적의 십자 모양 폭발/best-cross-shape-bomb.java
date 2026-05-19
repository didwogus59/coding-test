import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[][] arr = new int[len][len];

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int max = 0;
        for(int x = 0; x < len; x++) {
            for(int y = 0; y < len; y++) {
                int now = boom(arr,x,y);
//                System.out.println(now);
//                System.out.println();
                if(now > max) {
                    max = now;
                }
            }
        }
        System.out.println(max);
    }
    static int boom(int[][] arr, int x, int y) {
        int len = arr.length;
        int[][] tmp = new int[len][len];

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                tmp[i][j] = arr[i][j];
            }
        }
        int[] mx = {1,-1,0,0};
        int[] my = {0,0,1,-1};
        int boom = tmp[x][y];
        tmp[x][y] = 0;
        for(int i = 1; i < boom; i++) {
            for(int m = 0; m < 4; m++) {
                int nx = x + mx[m] * i;
                int ny = y + my[m] * i;
                if(inRange(nx,ny,len)) {
                    tmp[nx][ny] = 0;
                }
            }
        }

        drop(tmp);

//        for(int[] tmp2 : tmp) {
//            for(int tmp3 : tmp2) {
//                System.out.printf("%d ",tmp3);
//            }
//            System.out.println();
//        }

        return countPair(tmp);
    }

    static void drop(int[][] arr) {
        int len = arr.length;

        for(int y = 0; y < len; y++) {
            int nx = len - 1;
            for(int x = len - 1; x >= 0; x--) {
                if(arr[x][y] != 0) {
                    int tmp = arr[x][y];
                    arr[x][y] = 0;
                    arr[nx][y] = tmp;
                    nx--;

                }
            }

        }

    }
    static boolean inRange(int x, int y, int len) {
        return x >= 0 && y >= 0 && x < len && y < len;
    }
    static int countPair(int[][] arr) {
        int cnt = 0;
        int len = arr.length;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len - 1; j++) {
                if (arr[i][j] == arr[i][j + 1] && arr[i][j] != 0)
                    cnt++;
                if(arr[j][i] == arr[j + 1][i] && arr[j][i] != 0)
                    cnt++;
            }
        }
        return cnt;
    }
}


