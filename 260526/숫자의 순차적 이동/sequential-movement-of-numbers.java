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

        int time = sc.nextInt();
        int[] numX = new int[len * len + 1];
        int[] numY = new int[len * len + 1];

        for(int x = 0; x < len; x++) {
            for(int y = 0; y < len; y++) {
                int now = sc.nextInt();
                arr[x][y] = now;
                numX[now] = x;
                numY[now] = y;
            }
        }

        int[] dx = {-1,1,0,0,-1,-1,1,1};
        int[] dy = {0,0,-1,1,1,-1,1,-1};

        for(int i = 0; i < time; i++) {
            for(int n = 1; n <= len * len; n++) {
                int x = numX[n];
                int y = numY[n];
                int max = -1;
                int maxD = 0;
                for(int d = 0; d < 8; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if(inRange(nx,ny,len)) {
                        if(arr[nx][ny] > max) {
                            max = arr[nx][ny];
                            maxD = d;
                        }
                    }
                }
                int nx = x + dx[maxD];
                int ny = y + dy[maxD];

                int tmp = arr[x][y];
                arr[x][y] = max;
                arr[nx][ny] = tmp;
                numX[max] = x;
                numY[max] = y;
                numX[tmp] = nx;
                numY[tmp] = ny;

            }
        }
        for(int x = 0; x < len; x++) {
            for(int y = 0; y < len; y++) {
                System.out.printf("%d ",arr[x][y]);
            }
            System.out.println();
        }
    }
    static boolean inRange(int x, int y, int len) {
        return x >= 0 && y >= 0 && x < len && y < len;
    }
}


