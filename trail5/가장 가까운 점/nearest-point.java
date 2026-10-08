import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class Main {
    static int ans = 0;
    //    static int[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        PriorityQueue<pair> que = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            que.add(new pair(x, y));
        }

        for(int i = 0; i < m; i++) {
            pair tmp = que.poll();
            int x = tmp.x;
            int y= tmp.y;
            que.add(new pair(x + 2, y + 2));
        }
        pair tmp = que.poll();
        int x = tmp.x;
        int y= tmp.y;
        System.out.printf("%d %d\n",x,y);
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
            if(this.x + this.y - p.x - p.y != 0)
                return this.x + this.y - p.x - p.y;
            else if(this.x != p.x)
                return this.x - p.x;
            else
                return this.y - p.y;

        }
    }

}



