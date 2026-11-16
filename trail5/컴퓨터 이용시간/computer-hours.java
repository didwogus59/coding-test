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
        int[] arr = new int[n];
        pair[] p = new pair[n*2];
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            p[i] = new pair(a, 1, i);
            p[i + n] = new pair(b , -1, i);
        }
        Arrays.sort(p);
        int[] sum = new int[n * 2 + 1];
        sum[0] = p[0].y;
        ans = 0;
        int now = sum[0];
        int bef = 0;
        sum[0] = 1;
        arr[p[0].z] = 1;
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int i = 2; i <= n; i++) {
            que.add(i);
        }
        for(int i = 1; i < 2 * n; i++) {
            if(p[i].y == 1) {
                int min = que.poll();

                arr[p[i].z] = min;
            }
            else {
                que.add(arr[p[i].z]);
            }
        }
        for(int i = 0; i < n; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
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



