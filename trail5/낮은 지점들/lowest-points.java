import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int ans = 0;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Long, Long> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            if(map.containsKey(a)) {
                long c = map.get(a);
                if(b < c)
                    map.put(a, b);
            }
            else {
                map.put(a, b);
            }
        }
        long ansl = 0;
        for(long a : map.keySet()) {
            ansl += map.get(a);
        }
        System.out.println(ansl);
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


