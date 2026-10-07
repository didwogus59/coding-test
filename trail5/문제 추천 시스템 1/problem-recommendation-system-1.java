import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class Main {
    static int ans = 0;
    //    static int[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<pair> set = new TreeSet<>();
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            set.add(new pair(b, a));
        }

        int m = sc.nextInt();
        for(int i = 0; i < m; i++) {
            String cmd = sc.next();
            if("rc".equals(cmd)) {
                int now = sc.nextInt();
                if(now == 1) {
                    pair tmp = set.last();
                    System.out.println(tmp.y);
                }
                else {
                    pair tmp = set.first();
                    System.out.println(tmp.y);
                }
            }
            else if("ad".equals(cmd)) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                set.add(new pair(b, a));
            }
            else {
                int a = sc.nextInt();
                int b = sc.nextInt();
                pair del = set.ceiling(new pair(b,a));
                set.remove(del);
            }
        }
    }
    static class pair implements Comparable<pair>{
        public int x;
        public int y;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(pair p) {
            if(this.x != p.x) {
               return this.x - p.x;
            }
            else
                return this.y - p.y;
        }
    }
}



