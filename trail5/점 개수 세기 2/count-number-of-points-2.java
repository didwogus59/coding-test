import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class Main {
    static int ans = 0;
    //    static int[] arr;
//    static int[][] sum;
    static int n;
    static int k;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> mapX = new HashMap<>();
        Map<Integer, Integer> mapY = new HashMap<>();
        StringBuffer sb = new StringBuffer();
        Set<Integer> setX = new HashSet<>();
        Set<Integer> setY = new HashSet<>();
        n = sc.nextInt();
        k = sc.nextInt();
        pair[] arr = new pair[n];
        int[][] mat = new int[n + 1][n + 1];
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[i] = new pair(x, y);
            setX.add(x);
            setY.add(y);
        }

        int[] oriX = new int[setX.size()];
        int cnt = 0;
        for(int i : setX) {
            oriX[cnt] = i;
            cnt++;
        }
        cnt = 0;
        int[] oriY = new int[setY.size()];
        for(int i : setY) {
            oriY[cnt] = i;
            cnt++;
        }
        Arrays.sort(oriX);
        Arrays.sort(oriY);

        for(int i = 0; i < setX.size(); i++) {
                mapX.put(oriX[i], i + 1);
        }

        for(int i = 0; i < setY.size(); i++) {
                mapY.put(oriY[i], i + 1);
        }

        for(int i = 0; i < n; i++) {
            int x = mapX.get(arr[i].x);
            int y = mapY.get(arr[i].y);
            mat[x][y] += 1;
        }
//        for(int i = 0; i < 3; i++) {
//            System.out.printf("%d ", oriX[i]);
//        }
//        System.out.println();
//
//        for(int i = 0; i < 3; i++) {
//            System.out.printf("%d ", oriY[i]);
//        }
//        System.out.println();
        int[][] sum = new int[n + 2][n + 2];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + mat[i][j];
            }
        }

        for(int i = 0; i < k; i++) {
            int x1 = pt1(oriX, sc.nextInt());
            int y1 = pt1(oriY, sc.nextInt());
            int x2 = pt2(oriX, sc.nextInt());
            int y2 = pt2(oriY, sc.nextInt());
//            System.out.printf("%d %d %d %d\n",x1,y1,x2,y2);
            cnt = sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1];
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }
    static int pt1(int[] arr, int x) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] >= x) {
                return i + 1;
            }
        }
        return arr.length + 1;
    }
    /*
    1 2 3 3
    1 1 1 2
     */
    static int pt2(int[] arr, int x) {
        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] <= x) {
                return i + 1;
            }
        }
        return 0;
    }
    static class pair {
        int x;
        int y;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
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



