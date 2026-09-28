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
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if(map.get(arr[i]) == 1) {
                map2.put(cnt, arr[i]);
                cnt++;
            }
        }
        List<pair> list = new ArrayList<>();

        for(int i = 0; i < cnt; i++) {
            int a = map2.get(i);
            int b = map.get(a);
            list.add(new pair(b, a));
        }
        list.sort((a, b) -> {
            if(a.cnt != b.cnt)
                return b.cnt - a.cnt;
            return b.n - a.n;
        });
        for(int i = 0; i < m; i++) {
            System.out.printf("%d ", list.get(i).n);
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


