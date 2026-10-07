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
            int a = sc.nextInt();
            int b = sc.nextInt();
            pair tmp = new pair(a, b);
            pair now = set.ceiling(tmp);
            if(now != null) {
                sb.append(now.x);
                sb.append(" ");
                sb.append(now.n);
                sb.append("\n");
            }
            else {
                sb.append("-1 -1\n");
            }
        }
        System.out.print(sb);
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



