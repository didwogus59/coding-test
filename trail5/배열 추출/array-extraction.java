import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class Main {
    static int ans = 0;
    //    static int[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if(x == 0) {
                int out = 0;
                if(!que.isEmpty()) {
                    out = que.poll();
                }
                System.out.println(out);
            }
            else
                que.add(x);
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
            if(this.x + this.y - p.x - p.y != 0)
                return this.x + this.y - p.x - p.y;
            else if(this.x != p.x)
                return this.x - p.x;
            else
                return this.y - p.y;

        }
    }

}



