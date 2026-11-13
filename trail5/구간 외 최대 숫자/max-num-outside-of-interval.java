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
        int[] arr = new int[n];
        k = sc.nextInt();
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] L = new int[n + 2];
        int[] R = new int[n + 2];
        R[1] = arr[0];
        L[n] = arr[n-1];

        for(int i = 1; i < n; i++) {
            R[i + 1] = Math.max(R[i], arr[i]);
        }
        for(int i = n - 2; i >= 0; i--) {
            L[i + 1] = Math.max(L[i + 2], arr[i]);
        }
        for(int i = 0 ; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(Math.max(R[a - 1], L[b + 1]));
        }
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



