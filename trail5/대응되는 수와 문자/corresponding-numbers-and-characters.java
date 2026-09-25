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
        HashMap<String, String> map2 = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ans = 0;
        for(int i = 0; i < n; i++) {
            String a = sc.next();
            map.put(a, i + 1);
            map2.put(Integer.toString(i + 1), a);
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < m; i++) {
            String a = sc.next();
            if(map.containsKey(a)) {
                sb.append(map.get(a));
            }
            else {
                sb.append(map2.get(a));
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());

    }
}


