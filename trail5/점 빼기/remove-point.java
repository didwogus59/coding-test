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
        TreeSet<pair> set = new TreeSet<>();
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            set.add(new pair(a, b));
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < m; i++) {
            int now = sc.nextInt();
            pair del = set.ceiling(new pair(now, -1));
            if(del != null) {
                int a = del.x;
                int b = del.y;

                set.remove(del);
                sb.append(a).append(" ").append(b).append("\n");
            }
            else {
                sb.append("-1 -1\n");
            }
        }
        System.out.print(sb);
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



