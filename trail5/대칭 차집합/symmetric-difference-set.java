import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class Main {
    static int ans = 0;
    //    static int[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Set<Integer> set1 = new TreeSet<>();
        Set<Integer> set2 = new TreeSet<>();
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        for(int i = 0; i < n; i++) {
            set1.add(sc.nextInt());
        }

        for(int i = 0; i < m; i++) {
            set2.add(sc.nextInt());
        }
        ans = 0;
        for(int i : set1) {
            if(!set2.contains(i)) {
                ans++;
            }
        }

        for(int i : set2) {
            if(!set1.contains(i)) {
                ans++;
            }
        }
        System.out.print(ans);

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



