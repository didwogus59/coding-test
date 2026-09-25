import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int ans = 0;
    static int cnt = 0;
    static int len;
    static int m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] memo;
    static int[] memo2;
    static int[] arr;
    static int[] arr2;
    static int n;
    static boolean chk;
    static int cnt2 = 0;
    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ans = 0;
        for(int i = 0; i < n; i++) {
            String a = sc.next();
            if(map.containsKey(a)) {
                int cnt = map.get(a);
                map.remove(a);
                map.put(a, cnt + 1);
                ans = Math.max(ans, cnt + 1);
            }
            else {
                map.put(a, 1);
                ans = Math.max(ans, 1);
            }
        }
        System.out.printf("%d", ans);

    }
}


