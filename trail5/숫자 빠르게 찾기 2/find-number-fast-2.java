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
            int now = sc.nextInt();
            set.add(now);
        }
        for(int i = 0; i < m; i++) {
            int now = sc.nextInt();
            
            if(set.ceiling(now) != null) {
                System.out.println(set.ceiling(now));
            }
            else {
                System.out.println(-1);
            }
        }
        
    }
    static class pair {
        int cnt;
        int n;
        public pair(int cnt, int n) {
            this.cnt = cnt;
            this.n = n;
        }
    }
}



