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
        for(int i = 0; i < n; i++) {
            int now = sc.nextInt();

            if(set.floor(now) != null) {
                int del = set.floor(now);
                set.remove(del);
            }
            else {
                break;
            }
            ans = i + 1;
        }
        System.out.println(ans);
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



