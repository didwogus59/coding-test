import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class Main {
    static int ans = 0;
    //    static int[] arr;
    static int[][] sum;
    static int n;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        n = sc.nextInt();
        int[][] arr = new int[n + 1][n + 1];
        sum = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                sum[i][j] = sum[i][j-1] + arr[i][j];
            }
        }
        int max = -1000;
        for(int i = 0; i <= n; i++) {
            for(int j = i + 1; j <= n; j++) {
                max = Math.max(max, max_size(i,j));
            }
        }
        System.out.println(max);
    }
    static int max_size(int i, int j) {
        int max = -1;
        int bef = 0;
        for(int p = 1; p <= n; p++) {
            int now = sum[p][j] - sum[p][i];
            if(bef < 0) {
                bef = now;
            }
            else {
                bef += now;
            }
            max = Math.max(max, bef);
        }
        return max;
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



