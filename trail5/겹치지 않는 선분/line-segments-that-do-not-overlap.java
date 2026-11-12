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
        pair[] pairs = new pair[n];
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            pairs[i] = new pair(a, b);
        }
        Arrays.sort(pairs);
        int[] L = new int[n + 2];
        int[] R = new int[n + 2];
        L[0] = pairs[0].y;
        R[n-1] = pairs[n-1].y;
        for(int i = 1; i < n; i++) {
            L[i] = Math.max(L[i-1], pairs[i].y);
        }

        for(int i = n - 2; i >= 0; i--) {
            R[i] = Math.min(R[i+1], pairs[i].y);
        }
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            int now = pairs[i].y;
            int chk = 1;
            if(i > 0) {
                if(L[i-1] >= now)
                    chk = 0;
            }
            if(i < n - 1) {
                if(R[i + 1] <= now)
                    chk = 0;
            }
            cnt += chk;
        }
        System.out.println(cnt);
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


    static class pair implements Comparable<pair>{
        int x;
        int y;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int compareTo(pair b) {
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



