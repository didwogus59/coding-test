import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class Main {
    static int ans = 0;
    //    static int[] arr;
//    static int[][] sum;
    static int n;
    static int k;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        n = sc.nextInt();
        k = sc.nextInt();
        int[][] arr = new int[n + 1][4];
        int[][] sum = new int[n + 1][4];
        for(int i = 1; i <= n; i++) {
            int now = sc.nextInt();
            arr[i][now] = 1;
        }


        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= 3; j++) {
                sum[i][j] = sum[i-1][j] + arr[i][j];
            }
        }

        for(int i = 0; i < k; i++) {
            int b = sc.nextInt() -1 ;
            int a = sc.nextInt();

            sb.append(sum[a][1] - sum[b][1]).append(" ").append(sum[a][2] - sum[b][2]).append(" ").append(sum[a][3] - sum[b][3]).append("\n");
        }
        System.out.print(sb);
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



