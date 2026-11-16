import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class Main {
    static Long ans = 0L;
    //    static int[] arr;
//    static int[][] sum;
    static int n;
    static int k;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        n = sc.nextInt();

        int[] arr = new int[n * 2];
        int[] a = new int[n];
        int[] b = new int[n];
        pair[] p = new pair[n*2];
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            p[i] = new pair(x, 1);
            p[i + n] = new pair(y, -1);
        }
        Arrays.sort(p);

        int[] sum = new int[n * 2 + 1];

        sum[0] = p[0].y;
        int ans = sum[0];

        for(int i = 1; i < n * 2; i++) {
           sum[i] = sum[i-1] + p[i].y;
           ans = Math.max(sum[i], ans);
        }
        System.out.println(ans);
    }


    static class pair implements Comparable<pair>{
        int x;
        int y;
        int z;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public pair(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
        public int compareTo(pair b) {
            return this.x - b.x;
        }
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



