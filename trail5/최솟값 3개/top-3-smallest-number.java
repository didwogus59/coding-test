import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class Main {
    static int ans = 0;
    //    static int[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Long> que = new PriorityQueue<>();

        for(int i = 0; i < 2 && i < n; i++) {
            long now = sc.nextLong();
            que.add(now);
            System.out.println(-1);
        }
        for(int i = 0; i < n - 2; i++) {
            long now = sc.nextLong();
            que.add(now);
            long a = que.poll();
            long b = que.poll();
            long c = que.poll();
            System.out.println(a*b*c);
            que.add(a);
            que.add(b);
            que.add(c);
        }
    }
    static class pair implements Comparable<pair>{
        public int x;
        public int y;
        public int idx;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public pair(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
        @Override
        public int compareTo(pair p) {
            if(this.x != p.x)
                return this.x - p.x;
            return this.y - p.y;
        }
    }

}



