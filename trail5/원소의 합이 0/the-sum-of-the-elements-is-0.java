import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int ans = 0;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[4][n];

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int a = arr[1][i];
                int b = arr[0][j];
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int a = arr[2][i];
                int b = arr[3][j];
                if(map.containsKey(-a - b)) {
                    ans += map.get(-a -b);
                }
            }
        }
        System.out.println(ans);

    }
    static class pair {
        int cnt;
        int n;
        public pair(int cnt, int n) {
            this.cnt = cnt;
            this.n = n;
        }
    }
}


