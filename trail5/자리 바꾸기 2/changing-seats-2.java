import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int ans = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Set<Integer>> list = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            list.add(new HashSet<>());
            list.get(i).add(i);
        }
        arr = new int[n + 1];
        for(int i = 0; i < n; i++) {
            arr[i + 1] = i + 1;
        }
        int[][] arr2 = new int[m + 1][2];
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr2[i][0] = a;
            arr2[i][1] = b;
        }
        for(int i = 0; i < m * 3; i++) {
            int a = arr2[i % m][0];
            int b = arr2[i % m][1];

            list.get(arr[a]).add(b);
            list.get(arr[b]).add(a);

            int tmp = arr[a];
            arr[a] = arr[b];
            arr[b] = tmp;
        }

        for(int i = 1; i <= n; i++) {
            System.out.println(list.get(i).size());
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


