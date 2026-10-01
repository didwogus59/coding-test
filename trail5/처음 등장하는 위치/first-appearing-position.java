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
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if(!map.containsKey(a)) {
                map.put(a, i + 1);
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int a : map.keySet()) {
            sb.append(a);
            sb.append(" ");
            sb.append(map.get(a));
            sb.append("\n");
        }
        System.out.print(sb.toString());

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


