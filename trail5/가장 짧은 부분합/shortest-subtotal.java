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
        k = sc.nextInt();
        int[] arr = new int[n];

        int sum = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        ans = n;
        if(sum < k)
            ans = -1;
        sum = arr[0];
        int fst = 0;
        int end = 1;
        while(fst != n  && end != n) {
            if(sum >= k) {
                ans = Math.min(ans, end - fst);
                sum -= arr[fst];
                fst++;
            }
            if(sum < k) {
                sum += arr[end];
                end++;
            }
        }
        while(fst < n) {
            if(sum >= k) {
                ans = Math.min(ans, end - fst);
                sum -= arr[fst];
            }
            fst++;
        }
        while(end != n) {
            if(sum < k) {
                sum += arr[end];
            }
            end++;
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



