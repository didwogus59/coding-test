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
        Map<Integer, Integer> map = new HashMap<>();

        long[] mv = new long[n];
        long[] ey = new long[n];
        for(int i = 0; i < n - 1; i++) {
            mv[i] = sc.nextLong();
        }
        for(int i = 0; i < n; i++) {
            ey[i] = sc.nextLong();
        }

        long[] min = new long[n];
        min[0] = ey[0];
        for(int i = 1; i < n; i++) {
            min[i] = Math.min(min[i-1], ey[i]);
        }
        long ansL = 0L;
        for(int i = 0; i < n - 1; i++) {
            ansL += min[i] * mv[i];
        }
        System.out.println(ansL);
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



