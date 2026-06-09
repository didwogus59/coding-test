import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int ans = -1;
    static int len;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];
        bt(n, 0, arr, 0, m);
    }
    static void bt(int n,int now, int[] arr, int cnt, int max) {
        if(cnt == max) {
            for(int i : arr) {
                System.out.printf("%d ", i);
            }
            System.out.println();
        }
        else {
            for(int i = now + 1; i <= n; i++) {
                arr[cnt] = i;
                bt(n, i, arr, cnt + 1, max);
            }
        }
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < len && y < len;
    }
}


