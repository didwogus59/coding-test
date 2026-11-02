import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class Main {
    static int ans = 0;
    //    static int[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[][] sum = new int[n + 1][n + 1];
        int[][] arr = new int[n + 1][n + 1];
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j - 1] + arr[i][j];
            }
        }
        
        for(int i = k; i <= n; i++) {
            for(int j = k; j <= n; j++) {
                int now = sum[i][j] - sum[i-k][j] - sum[i][j - k] + sum[i-k][j-k];
                ans = Math.max(ans, now);
            }
        }
        System.out.println(ans);


    }
    static class node implements Comparable<node>{
        node pre = null;
        node nxt = null;
        public int val;
        public String str;
        public node(int v) {
            this.val = v;
        }
        public node(String str) {this.str = str;}

        @Override
        public int compareTo(node b) {
            return this.val - b.val;
        }
    }

}



