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
        TreeSet<Integer> set = new TreeSet<>();

        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            set.add(a);
        }
        for(int i = 0; i < m; i++) {
            int now = sc.nextInt();
            int out = -1;
            if(set.floor(now) != null) {
                out = set.floor(now);
                set.remove(out);
            }
            System.out.println(out);
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



