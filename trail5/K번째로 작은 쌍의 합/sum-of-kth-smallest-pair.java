import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class Main {
    static int ans = 0;
    //    static int[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[] arr1 = new int[n];
        int[] arr2 = new int[m];

        for(int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        for(int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        Arrays.sort(arr1);

        Arrays.sort(arr2);
        PriorityQueue<pair> que = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            que.add(new pair(arr1[i] + arr2[0], 1));
        }
        int ans = 0;
        for(int i = 0; i < k; i++) {
            pair now = que.poll();

            int x = now.x;
            ans = x;
            int y = now.y;
            if(y < m)
                que.add(new pair(x - arr2[y-1] + arr2[y], y + 1));

        }
        System.out.println(ans);
    }
    static class pair implements Comparable<pair>{
        public int x;
        public int y;
        public int idx;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public pair(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
        @Override
        public int compareTo(pair p) {
            return this.x - p.x;
        }
    }

}



