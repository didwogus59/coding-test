import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class Main {
    static int ans = 0;
    //    static int[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            PriorityQueue<Integer> que1 = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> que2 = new PriorityQueue<>();
            int m = sc.nextInt();
            int[] arr = new int[m];
            for (int j = 0; j < m; j++) {
                arr[j] = sc.nextInt();
            }
            StringBuffer sb = new StringBuffer();
            sb.append(arr[0]).append(" ");

            que1.add(arr[0]);
            for(int j = 1; j < m; j += 2) {
                int sml = Math.min(arr[j], arr[j + 1]);
                int big = Math.max(arr[j], arr[j + 1]);
                que1.add(sml);
                que2.add(big);
                if(que1.peek() > que2.peek()) {
                    int a = que1.poll();
                    int b = que2.poll();
                    que2.add(a);
                    que1.add(b);
                }
                sb.append(que1.peek()).append(" ");
            }
            sb.append("\n");
            System.out.print(sb);
        }
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



