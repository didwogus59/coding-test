import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class Main {
    //    static int[] arr;
//    static int[][] sum;
    static int n;
    static int k;
    static long ans = 0L;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        n = sc.nextInt();
        k = sc.nextInt();
        pair[] p = new pair[n];
        long sum = 0;
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            p[i] = new pair(y, x);
        }
        Arrays.sort(p);
        PriorityQueue<pair> que = new PriorityQueue<>();
        que.add(p[0]);
        sum += p[0].y;
        ans = sum;
        for(int i = 1; i < n; i++) {
            while(p[i].x - que.peek().x > k * 2) {
                sum -= que.peek().y;
                que.poll();
                if(que.isEmpty())
                    break;
            }

            sum += p[i].y;
            que.add(p[i]);
            ans = Math.max(sum, ans);
        }
        System.out.println(ans);
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



