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
        for(int i = 1; i <= m; i++) {
            set.add(i);
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            set.remove(a);
            sb.append(set.last());
            sb.append("\n");

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



