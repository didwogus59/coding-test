import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class Main {
    static Long ans = 0L;
    //    static int[] arr;
//    static int[][] sum;
    static int n;
    static int k;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        n = sc.nextInt();
        long[] cntC = new long[n];
        long[] cntW = new long[n];

        int[] arr = new int[n];
        String tmp = sc.next();
        for(int i = 0; i < n; i++) {
            char now = tmp.charAt(i);
            if('C' == now) {
                arr[i] = 0;
            }
            else if('O' == now) {
                arr[i] = 1;
            }
            else {
                arr[i] = 2;
            }
        }
        if(arr[0] == 0) {
            cntC[0] = 1;
        }
        for(int i = 1; i < n; i++) {
            cntC[i] = cntC[i-1];
            if(arr[i] == 0)
                cntC[i] += 1;

        }
        if(arr[n-1] == 2) {
            cntW[n-1] = 1;
        }
        for(int i = n - 2; i >= 0; i--) {
            cntW[i] = cntW[i + 1];
            if(arr[i] == 2)
                cntW[i] += 1;
        }
        ans = 0L;
        for(int i = 0; i < n; i++) {
            if(arr[i] == 1) {
                ans += cntW[i] * cntC[i];
            }
        }
        System.out.println(ans);
    }
    //h 0, s 1, p 2
    //
    static int rsp(int a, int b) {
        if(a == 0 && b == 1)
            return 1;
        if(a == 1 && b == 2)
            return 1;
        if(a == 2 && b == 0)
            return 1;
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



