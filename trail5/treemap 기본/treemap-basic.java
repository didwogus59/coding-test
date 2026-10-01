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
            String tmp = sc.next();
            if("add".equals(tmp)) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                map.put(a, b);
            }
            if("remove".equals(tmp)) {
                int a = sc.nextInt();
                map.remove(a);
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
            if("print_list".equals(tmp)) {
                if(map.isEmpty()) {
                    System.out.println("None");
                }
                else {
                    for (int a : map.values()) {
                        System.out.printf("%d ", a);
                    }
                    System.out.println();
                }
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


