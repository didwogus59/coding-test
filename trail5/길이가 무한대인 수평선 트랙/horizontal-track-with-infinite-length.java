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
        long[][] arr = new long[n + 1][2];

        for(int i = 0; i < n; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            arr[i][0] = a;
            arr[i][1] = b;
        }
        long bs = arr[n - 1][1];
        long bp = arr[n - 1][0];
        int cnt = n;
        for(int i = n - 2; i >= 0; i--) {
            long spd = arr[i][1];
            if(spd > bs) {
                long dis = bp - arr[i][0];
                if(dis <= (spd - bs) * m) {
                    cnt--;
                }
                else {
                    bs = spd;
                    bp = arr[i][0];
                }
            }
            else {
                bs = spd;
                bp = arr[i][0];
            }
        }
        System.out.println(cnt);

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



