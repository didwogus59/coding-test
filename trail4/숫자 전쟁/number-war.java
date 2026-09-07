import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int ans = 0;
    static int len;
    static int m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] memo;
    static int[] memo2;
    static int[] arr;
    static int[] arr2;
    static int n;
    static List<pair> list;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n + 1];
        arr2 = new int[n + 1];
//        list = new ArrayList<>();
        List<pair> list = new ArrayList<>();

        int sum = 0;
        for(int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        memo = new int[n + 2][n + 2];
        for(int i = 0; i < n; i++) {
            if(arr[0] < arr2[i]) {
                memo[1][i] = arr[0];
                break;
            }
            if(arr[0] == arr2[i])
                break;
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i] > arr2[j]) {
                    memo[i][j + 1] = Math.max(memo[i][j],memo[i][j+1]);
                }
                if(arr[i] < arr2[j]) {
                    memo[i + 1][j] = Math.max(memo[i][j] + arr[i], memo[i + 1][j]);
                }
                memo[i + 1][j + 1] = Math.max(memo[i][j], memo[i + 1][j + 1]);
            }
        }
        for(int i = 0; i < n +1; i++) {
            ans = Math.max(ans, memo[n][i]);
        }
//        for(int i = 1; i < n + 1; i++) {
//            for(int j = 0; j < n + 1; j++) {
//                System.out.printf("%d ",memo[i][j]);
//            }
//            System.out.println();
//        }
        System.out.println(ans);
    }
    static int gap(int sum, int x) {
        int y = sum - x;
        return x > y ? x - y : y - x;
    }
    static void dp(int a, int b, int max, int now) {

    }

    //
    static boolean inRange(int x, int y, int lenX, int lenY) {
        return x >= 0 && y >= 0 && x < lenX && y < lenY;
    }
    static class pair {
        int x;
        int y;
        int cnt = 0;
        int now = 0;
        int min;
        int max;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public pair(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}


