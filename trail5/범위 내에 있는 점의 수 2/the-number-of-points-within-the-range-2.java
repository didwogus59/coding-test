import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class Main {
    static int ans = 0;
    //    static int[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[1000002];

        for(int i = 0; i < n; i++) {
            int now = sc.nextInt();
            arr[now + 1] = 1;
        }

        int[] sum = new int[1000002];
        for(int i = 1; i < 1000001; i++) {
            sum[i] = sum[i-1] + arr[i];
        }

        for(int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int now = sum[b + 1] - sum[a];
            sb.append(now).append("\n");
        }

        System.out.println(sb);

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



