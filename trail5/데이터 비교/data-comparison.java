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
        Set<Integer> set1 = new HashSet<>();

        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            set1.add(a);
        }

        int m = sc.nextInt();
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            if(set1.contains(a)) {
                System.out.print("1 ");
            }
            else {
                System.out.print("0 ");
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


