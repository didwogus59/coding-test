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
            String tmp = sc.next();

            if("push".equals(tmp)) {
                int now = sc.nextInt();
                que.add(now);
            } else if("pop".equals(tmp)) {
                int now = que.poll();
                System.out.println(now);
            } else if("size".equals(tmp)) {
                System.out.println(que.size());
            } else if("empty".equals(tmp)) {
                int now = 0;
                if(que.isEmpty()) {
                    now = 1;
                }
                System.out.println(now);
            } else {
                System.out.println(que.peek());
            }
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
            if(this.idx == p.idx)
                return this.idx - p.idx;
            if(this.x != p.x) {
               return this.x - p.x;
            }
            else
                return this.y - p.y;
        }
    }

}



