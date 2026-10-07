import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class Main {
    static int ans = 0;
    //    static int[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        TreeSet<Integer> set = new TreeSet<>();
        int fst = sc.nextInt();
        ans = fst;
        set.add(fst);
        set.add(0);

        System.out.println(ans);
        
        for(int i = 0; i < n - 1; i++) {
            int now = sc.nextInt();
            set.add(now);
            if(set.higher(now) != null) {
                int dis = set.higher(now) - now;
                ans = Math.min(ans, dis);
            }
            if(set.lower(now) != null) {
                int dis = now - set.lower(now);
                ans = Math.min(ans, dis);
            }

            System.out.println(ans);
        }

    }
    static class pair implements Comparable<pair>{
        public int x;
        public int n;
        public pair(int x, int n) {
            this.x = x;
            this.n = n;
        }
        @Override
        public int compareTo(pair p) {
            if(this.x != p.x) {
               return this.x - p.x;
            }
            else
                return this.n - p.n;
        }
    }
}



