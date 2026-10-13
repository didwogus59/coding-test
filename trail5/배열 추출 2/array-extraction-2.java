import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class Main {
    static int ans = 0;
    //    static int[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<pair> que = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            int now = sc.nextInt();
            if(now != 0)
                que.add(new pair(Math.abs(now), now));
            else {
                if(que.isEmpty()) {
                    ans = 0;
                }
                else {
                    pair tmp = que.poll();
                    ans = tmp.y;
                }

                System.out.println(ans);
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
            if(this.x != p.x)
                return this.x - p.x;
            return this.y - p.y;
        }
    }

}



