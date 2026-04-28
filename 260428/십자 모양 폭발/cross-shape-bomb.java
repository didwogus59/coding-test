import java.util.*;
public class Main {
    static int[] mx = {0, 1, 0, -1};
    static int[] my = {1, 0, -1, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int tmp = sc.nextInt();
                arr[i][j] = tmp;
            }
        }
        int x = sc.nextInt() - 1;
        int y = sc.nextInt() - 1;

        int range = arr[x][y];
        arr[x][y] = 0;
        int[] mx = {1,-1,0,0};
        int[] my = {0,0,1,-1};
        for(int i = 1; i < range; i++) {
            for(int j = 0; j < 4; j++) {
                int nx = x + mx[j] * i;
                int ny = y + my[j] * i;
                if(inRange(n, nx, ny)) {
                    arr[nx][ny] = 0;
                }
            }
        }
        for(int i = n - 1; i >= 0; i--) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 0) {
                    int now = i;
                    while(now >= 0) {
                        if(arr[now][j] != 0) {
                            arr[i][j] = arr[now][j];
                            arr[now][j] = 0;
                            break;
                        }
                        now--;
                    }
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.printf("%d ",arr[i][j]);
            }
            System.out.println();
        }
    }
    static boolean inRange(int n, int x, int y) {
        return x >= 0 && y >= 0 & x < n && y < n;
    }
}
/*
4
1 2 4 3
3 2 2 3
3 1 6 2
4 5 4 4
2 3
* */