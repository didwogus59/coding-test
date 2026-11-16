import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class Main {
    //    static int[] arr;
//    static int[][] sum;
    static int n;
    static int k;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        n = sc.nextInt();
//        k = sc.nextInt();
        int[] arr = new int[n * 2];
        pair[] p = new pair[n*2];
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            p[i] = new pair(a, 1);
            p[i + n] = new pair(b , -1);
        }
        Arrays.sort(p);
        int[] sum = new int[n * 2 + 1];
        sum[0] = p[0].y;
        ans = 0;
        int now = sum[0];
        int bef = 0;
        for(int i = 1; i < 2 * n; i++) {
            sum[i] = sum[i-1] + p[i].y;
            if(sum[i] == 0) {
                ans = Math.max(ans, p[i].x - p[bef].x);
                bef = i + 1;
            }
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



