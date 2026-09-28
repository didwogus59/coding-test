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
        Map<String, Integer> map = new HashMap<>();
        String[] strs = new String[n];
        for(int i = 0; i < n; i++) {
            String tmp = sc.next();
            int len = tmp.length();
            char[] cArr = new char[len];
            for(int j = 0; j < len; j++) {
                cArr[j] = tmp.charAt(j);
            }
            Arrays.sort(cArr);

            StringBuffer sb = new StringBuffer();
            for(int j = 0; j < len; j++) {
                sb.append(cArr[j]);
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }
        
        ans = 0;
        for(String a : map.keySet()) {
            if(map.get(a) > ans) {
                ans = map.get(a);
            }
        }
        System.out.println(ans);

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


