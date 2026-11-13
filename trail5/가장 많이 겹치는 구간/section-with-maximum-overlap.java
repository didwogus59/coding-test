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
        int[] arr = new int[200001];
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a] += 1;
            arr[b] -= 1;
        }
        int[] sum = new int[200001];
        sum[0] = arr[0];

        for(int i = 1; i < 200001; i++) {
            sum[i] = arr[i] + sum[i-1];
            ans = Math.max(sum[i], ans);
        }
        System.out.println(ans);
    }


    static class pair implements Comparable<pair>{
        int x;
        int y;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
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



