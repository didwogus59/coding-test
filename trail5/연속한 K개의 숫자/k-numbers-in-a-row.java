import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class Main {
    static int ans = 0;
    //    static int[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int b = sc.nextInt();
        int[] sum = new int[n + 1];
        int[] arr = new int[n + 1];

        for(int i = 0; i < b; i++) {
            int now = sc.nextInt();
            arr[now] = 1;
        }
        for(int i = 1; i <= n; i++) {
            sum[i] = arr[i] + sum[i-1];
        }
        ans = b;
        for(int i = k; i <= n; i++) {
            int now = sum[i] - sum[i - k];
            ans = Math.min(ans, now);
        }
        System.out.println(ans);


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



