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
        HashMap<Integer, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for(int i = 0; i < n; i++) {
            String tmp = sc.next();
            if("add".equals(tmp)) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                map.put(a, b);
            }
            if("find".equals(tmp)) {
                int a = sc.nextInt();
                if(map.containsKey(a)) {
                    System.out.println(map.get(a));
                }
                else {
                    System.out.println("None");
                }
            }
            if("remove".equals(tmp)) {
                int a = sc.nextInt();
                map.remove(a);
            }
        }
    }
}


