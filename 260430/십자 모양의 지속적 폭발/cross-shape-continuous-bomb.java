import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = h;
        int time = sc.nextInt();
        int[][] arr = new int[h][w];
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < time; i++) {
            int line = sc.nextInt() - 1;
            for(int j = 0; j < h; j++) {
                if(arr[j][line] != 0) {
                    int rg = arr[j][line];
                    arr[j][line] = 0;
                    for(int rgt = 0; rgt < rg && line + rgt < w; rgt++) {
                        arr[j][line + rgt] = 0;
                    }
                    for(int lft = 0; lft < rg && line - lft >= 0; lft++) {
                        arr[j][line - lft] = 0;
                    }
                    for(int d = 0; d < rg && j + d < h; d++) {
                        arr[j+d][line] = 0;
                    }
                    break;
                }
            }
            for(int y = 0; y < w; y++) {
                for(int cnt = 0; cnt < h; cnt++) {
                    for(int x = h - 1; x >= 1; x--) {
                        if(arr[x][y] == 0) {
                            arr[x][y] = arr[x-1][y];
                            arr[x-1][y] = 0;
                        }
                    }
                }
            }
        }
        for(int[] tmp : arr) {
            for(int n : tmp) {
                System.out.printf("%d ", n);
            }
            System.out.println();
        }


    }
}