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
        TreeSet<pair> set = new TreeSet<>();
        int[] sum = new int[n * 2];
        pair[] p = new pair[n * 2];
        pair[] ori = new pair[n];
        for(int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();

            p[i] = new pair(x1,1, i);
            p[i + n] = new pair(x2,-1, i);
            ori[i] = new pair(x1, x2);
        }
        Arrays.sort(p);
        int max = 0;
        sum[0] = p[0].y;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n * 2; i++) {
            map.put(p[i].x, i);
        }
        int bef = p[0].x;
        for(int i = 1; i < n * 2; i++) {
            sum[i] = sum[i - 1] + p[i].y;
            if(sum[i] == 0) {
                max += p[i].x - bef;
            }
            if(sum[i - 1] == 0) {
                bef = p[i].x;
            }
        }
        int[] len = new int[n *  2];
        for(int i = 1; i < n * 2; i++) {
            if(sum[i] >= 1 && sum[i - 1] >= 2) {
                len[i] = p[i].x - p[i-1].x;
            }
        }
        int[] disR = new int[n * 2 + 1];

        disR[0] = len[0];

        for(int i = 1; i < n * 2; i++) {
            disR[i] = disR[i-1] + len[i];
        }

        int ans = max;

        for(int i = 0; i < n; i++) {
            int x1 = map.get(ori[i].x);
            int x2 = map.get(ori[i].y);
            int now = ori[i].y - ori[i].x - (disR[x2] - disR[x1]);
//            System.out.printf("%d %d\n", ori[i].y - ori[i].x, disR[x2] - disR[x1] );
            ans = Math.min(ans, now);
        }
        System.out.println(max - ans);
    }


    static class pair implements Comparable<pair>{
        int x;
        int y;
        int z = 0;
        int idx;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public pair(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
        @Override
        public int compareTo(pair b) {
            if(this.z != b.z) {
//                return this.z - b.z;
            }
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



