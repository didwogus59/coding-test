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
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] arrA = new int[n + 1][m + 1];
        int[][] arrB = new int[n + 1][m + 1];
        int[][] arrC = new int[n + 1][m + 1];
        int[][] sumA = new int[n + 1][m + 1];
        int[][] sumB = new int[n + 1][m + 1];
        int[][] sumC = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++) {
            String tmp = sc.next();
            for(int p = 0; p < tmp.length(); p++) {
                char c = tmp.charAt(p);
                if(c == 'a') {
                    arrA[i][p + 1] = 1;
                }
                else if(c == 'b') {
                    arrB[i][p + 1] = 1;
                }
                else {
                    arrC[i][p + 1] = 1;
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                sumA[i][j] = sumA[i-1][j] + sumA[i][j-1] - sumA[i-1][j-1] + arrA[i][j];
                sumB[i][j] = sumB[i-1][j] + sumB[i][j-1] - sumB[i-1][j-1] + arrB[i][j];
                sumC[i][j] = sumC[i-1][j] + sumC[i][j-1] - sumC[i-1][j-1] + arrC[i][j];
            }
        }
        int max = -1000;
        for(int i = 0; i < k; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            int a = sumA[x2][y2] + sumA[x1-1][y1-1] - sumA[x1-1][y2] - sumA[x2][y1-1];
            int b = sumB[x2][y2] + sumB[x1-1][y1-1] - sumB[x1-1][y2] - sumB[x2][y1-1];
            int c = sumC[x2][y2] + sumC[x1-1][y1-1] - sumC[x1-1][y2] - sumC[x2][y1-1];

            sb.append(a).append(" ").append(b).append(" ").append(c).append("\n");
        }
        System.out.println(sb);
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



