import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class Main {
    //    static int[] arr;
//    static int[][] sum;
    static int n;
    static int k;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        n = sc.nextInt();
        int[][] mat = new int[n+1][n+1];
        Map<Integer, Integer> mapX = new HashMap<>();
        Map<Integer, Integer> mapY = new HashMap<>();
        int[] xv = new int[n];
        int[] yv = new int[n];
        pair[] p = new pair[n];
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            xv[i] = x;
            yv[i] = y;
            p[i] = new pair(x,y);
        }
        Arrays.sort(xv);
        Arrays.sort(yv);
        for(int i = 0; i < n; i++) {
            mapX.put(xv[i], i);
            mapY.put(yv[i], i);
        }
        for(int i = 0; i < n; i++) {
            int x = mapX.get(p[i].x);
            int y = mapY.get(p[i].y);
            mat[x][y] = 1;
        }
        int[][] sum = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + mat[i-1][j-1];
            }
        }
        ans = n;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                int a1 = sum[i][j];
                int a2 = sum[n][j] - a1;
                int a3 = sum[i][n] - a1;
                int a4 = n - a1 - a2 - a3;
//                    System.out.printf("%d %d : %d %d %d %d\n", i, j, a1, a2, a3, a4);
                    int now = Math.max(a1, Math.max(a2, Math.max(a3, a4)));
                    ans = Math.min(ans, now);
            }
        }

        System.out.println(ans);
    }


    static class pair implements Comparable<pair>{
        int x;
        int y;
        int z = 0;
        int idx;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public pair(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
        @Override
        public int compareTo(pair b) {
            if(this.z != b.z) {
//                return this.z - b.z;
            }
            return this.x - b.x;
        }
    }
    static class node implements Comparable<node>{
        node pre = null;
        node nxt = null;
        public int val;
        public String str;
        public node(int v) {
            this.val = v;
        }
        public node(String str) {this.str = str;}

        @Override
        public int compareTo(node b) {
            return this.val - b.val;
        }
    }

}



