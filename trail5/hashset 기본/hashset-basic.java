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
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < n; i++) {
            String tmp = sc.next();
            int a = sc.nextInt();
            if("add".equals(tmp)) {
                set.add(a);
            }
            else if("remove".equals(tmp)) {
                set.remove(a);
            }
            else {
                if(set.contains(a)) {
                    System.out.println("true");
                }
                else {
                    System.out.println("false");
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


