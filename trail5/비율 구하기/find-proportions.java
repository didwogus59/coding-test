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
        Map<String, Integer> map = new TreeMap<>();
        for(int i = 0; i < n; i++) {
            String tmp = sc.next();

            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        for (String str : map.keySet()) {
            float rate = (float)map.get(str) / n * 100;
            System.out.printf("%s %.4f\n", str, rate);
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


