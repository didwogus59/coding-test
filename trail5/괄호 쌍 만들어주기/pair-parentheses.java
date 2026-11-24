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
//        n = sc.nextInt();
//        k = sc.nextInt();
        String tmp = sc.next();
        n = tmp.length();
        int[] sumL = new int[n];
        int[] sumR = new int[n];
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            if(tmp.charAt(i) == '(')
                arr[i] = 1;
        }
        for(int i = 1; i < n; i++) {
            if(arr[i] == 1 && arr[i-1] == 1) {
                sumR[i] += 1;
            }
        }
        for(int i = n - 2; i >= 0; i--) {
            sumL[i] = sumL[i + 1];
            if(arr[i] == 0 && arr[i+ 1] == 0)
                sumL[i] += 1;
        }
        Long ansL = 0L;
        for(int i = 0; i < n; i++) {
            if(sumR[i] == 1) {
                ansL += sumL[i];
            }
        }
        System.out.println(ansL);
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



