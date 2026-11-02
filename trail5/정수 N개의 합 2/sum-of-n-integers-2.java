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
        int[] arr = new int[n];
        int[] sum = new int[n];
        int bef = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum[i] = bef + arr[i];
            bef = sum[i];
        }
        ans = sum[k - 1];
        for(int i = 0; i + k < n; i++) {
            ans = Math.max(ans, sum[i+k] - sum[i]);
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



