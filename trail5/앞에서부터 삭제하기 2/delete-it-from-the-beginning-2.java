import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class Main {
    static int ans = 0;
    //    static int[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> que = new PriorityQueue<>();
        int[] arr = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++) {
            int now = sc.nextInt();
            arr[i] = now;
        }
        float avg = 0;
        que.add(arr[n-1]);
        sum += arr[n-1];
        for(int i = n - 2; i >= 1; i--) {
            int now = arr[i];
            que.add(now);
            sum += now;
            int min = que.peek();
            avg = Math.max(avg, (float)(sum - min) / (que.size() - 1) );
        }
        System.out.printf("%.2f", avg);
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
            if(this.x + this.y - p.x - p.y != 0)
                return this.x + this.y - p.x - p.y;
            else if(this.x != p.x)
                return this.x - p.x;
            else
                return this.y - p.y;

        }
    }

}



