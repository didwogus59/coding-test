import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class Main {
    static int ans = 0;
    //    static int[] arr;
    static int[][] sum;
    static int n;
    static int k;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        n = sc.nextInt();
        k = sc.nextInt();
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

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                max = Math.max(max, max_size(i, j));
            }
        }
        System.out.println(max);
    }
    static int max_size(int i, int j) {
        int cal = 0;
        for(int h = 0; h <= k; h++) {
            int left = Math.max(0, j - k + h - 1);
            int right = Math.min(n, j + k - h);

            if(i + h <= n)
                cal += sum[i + h][right] - sum[i + h][left];
            if(h != 0)
                if(i - h >= 0)
                    cal += sum[i - h][right] - sum[i - h][left];
        }
        return cal;
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



