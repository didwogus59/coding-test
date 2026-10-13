import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class Main {
    static int ans = 0;
    //    static int[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<pair> time = new PriorityQueue<>();
        PriorityQueue<pair> line = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            int arrive = sc.nextInt();
            int play = sc.nextInt();
            time.add(new pair(arrive, i, play));
        }
        int now = 0;
        while(!time.isEmpty() || !line.isEmpty()) {
            if(!time.isEmpty()) {
                while (now >= time.peek().x) {
                    pair tmp = time.poll();
                    line.add(new pair(tmp.y, tmp.idx, tmp.x));
                    if (time.isEmpty()) {
                        break;
                    }
                }
                if(line.isEmpty()) {
                    pair tmp = time.poll();
                    line.add(new pair(tmp.y, tmp.idx, tmp.x));
                    now = tmp.x;
//                    System.out.println(now);
                }
            }

            pair player = line.poll();
            int wait = now - player.idx;
            ans = Math.max(ans, wait);

//            System.out.printf("%d %d %d\n",now, player.idx, wait);
            now += player.y;
//            System.out.println(now);
        }
        System.out.println(ans);
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



