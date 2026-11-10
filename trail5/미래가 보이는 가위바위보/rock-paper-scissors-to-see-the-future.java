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
        int[][] winL = new int[n][3];
        int[][] winR = new int[n][3];
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            String tmp = sc.next();
            if("H".equals(tmp)) {
                arr[i] = 0;
            }
            else if("S".equals(tmp)) {
                arr[i] = 1;
            }
            else {
                arr[i] = 2;
            }
        }
        for(int i = 0; i < 3; i++) {
            winL[0][i] = rsp(i, arr[0]); 
        }
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                winL[i][j] = winL[i - 1][j] + rsp(j, arr[i]);
            }
        }
        for(int i = 0; i < 3; i++) {
            winR[n-1][i] = rsp(i, arr[n-1]);
        }

        for(int i = n-2; i >= 0; i--) {
            for(int j = 0; j < 3; j++) {
                winR[i][j] = winR[i + 1][j] + rsp(j, arr[i]);
            }
        }
        ans = 0;
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < 3; j++) {
                for(int p = 0; p < 3; p++) {
                    int now = winL[i][j] + winR[i + 1][p];
                    ans = Math.max(ans, now);
                }
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



