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
        k = sc.nextInt();
        int[] arr = new int[n * 2];
        int[] a = new int[n];
        int[] b = new int[n];
        pair[] p = new pair[n*2];
        int now = 0;
        for(int i = 0; i < n; i++) {
            int dis = sc.nextInt();
            String dir = sc.next();
            int nxt = now;
            if("R".equals(dir)) {
                nxt += dis;
                p[i] = new pair(now, 1);
                p[i + n] = new pair(nxt, -1);
            }
            else {
                nxt -= dis;
                p[i] = new pair(nxt, 1);
                p[i + n] = new pair(now, -1);
            }
            now = nxt;
        }
        Arrays.sort(p);
        int[] sum = new int[n * 2 + 1];
        sum[0] = p[0].y;
        ans = 0;
        for(int i = 1; i < 2 * n; i++) {
            if(sum[i - 1] >= k) {
                ans += p[i].x - p[i - 1].x;
            }
            sum[i] = sum[i-1] + p[i].y;
//            System.out.printf("%d(%d) ", sum[i],p[i].x);
        }
//        System.out.println();
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



