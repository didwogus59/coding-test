import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int ans = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            arr[i] = a;
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        for(int i = 0; i < n; i++) {
            int a = arr[i];
            if(map.containsKey(a)) {
                map.put(a, map.getOrDefault(a, 0) - 1);
            }
            for(int j = 0; j < i; j++) {
                int b = arr[j];
                if(map.containsKey(m - a - b)) {
                    ans += map.get(m - a - b);
                }
            }
        }
        System.out.printf("%d",ans);
    }
}


