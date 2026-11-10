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
        StringBuffer sb = new StringBuffer();
        n = sc.nextInt();
        int[] maxL = new int[n];
        int[] maxR = new int[n];
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        maxR[0] = arr[0];
        for(int i = 1; i < n; i++) {
            maxR[i] = Math.max(arr[i], maxR[i - 1]);
        }
        maxL[n - 1] = arr[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            maxL[i] = Math.max(arr[i], maxL[i + 1]);
        }
        ans = 0;
        for(int i = 2; i < n - 2; i++) {
            int now = arr[i] + maxR[i - 2] + maxL[i + 2];
            ans = Math.max(ans, now);
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



