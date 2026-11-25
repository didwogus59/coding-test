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
        int[] arr = new int[n];
        int[] sum = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt() % 7;
        }
        sum[0] = arr[0];

        int[][] sv = new int[7][2];
        sv[sum[0]][1] = 0;
        sv[sum[0]][0] = 0;
        if(sum[0] == 0)
            ans = 1;
        for(int i = 1; i < n; i++) {
            sum[i] = (sum[i-1] + arr[i]) % 7;
            if(sum[i] == 0)
                ans = i + 1;
            if(sv[sum[i]][0] == 0 && sum[i] != sum[0])
                sv[sum[i]][0] = i;
            sv[sum[i]][1] = i;
        }
//        for(int i = 0; i < n; i++) {
//            System.out.printf("%d ",sum[i]);
//        }
//        System.out.println();
//        for(int i = 0; i < 7; i++) {
//            System.out.printf("%d %d %d\n",i,sv[i][0],sv[i][1]);
//        }
        for(int i = 0; i < 7; i++) {
            ans = Math.max(sv[i][1] - sv[i][0], ans);
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



