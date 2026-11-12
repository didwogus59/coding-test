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
        long[] arr = new long[n];
        long sum = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
            sum += arr[i];
        }
        long div = sum / 4;
        long[] R = new long[n + 2];
        long[] L = new long[n + 2];
        R[0] = arr[0];
        for(int i = 1; i < n; i++) {
            R[i] = R[i - 1] + arr[i];
        }
        L[n - 1] = arr[n-1];
        for(int i = n - 2; i >= 0; i--) {
            L[i] = L[i + 1] + arr[i];
        }
        long[][] d = new long[n][3];
        for(int i = 0; i < n; i++) {
            if(R[i] == div) {
                d[i][0] = 1;
            }
            if(i > 0)
                d[i][0] += d[i-1][0];
        }
        for(int i = 1; i < n; i++) {
            if(R[i] == div * 2 && d[i-1][0] != 0) {
                d[i][1] = d[i-1][0];
            }
            d[i][1] += d[i-1][1];
        }

        for(int i = 2; i < n - 1; i++) {
            if(R[i] == div * 3 && d[i-1][1] != 0 && L[i + 1] == div) {
                d[i][2] = d[i-1][1];
            }

            d[i][2] += d[i-1][2];
        }
            System.out.println(d[n-2][2]);
        

//        System.out.println();
//        for(int i = 0; i < 3; i++) {
//            for(int j = 0; j < n; j++) {
//                System.out.printf("%d ",d[j][i]);
//            }
//            System.out.println();
//        }
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



