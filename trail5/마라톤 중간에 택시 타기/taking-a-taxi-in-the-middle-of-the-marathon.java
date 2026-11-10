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
        pair[] pt = new pair[n];
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            pt[i] = new pair(x,y);
        }
        int[] disL = new int[n];
        int[] disR = new int[n];
        for(int i = 1; i < n; i++) {
            int now = dis(pt[i], pt[i - 1]);
            disL[i] = disL[i - 1] + now;
        }

        for(int i = n - 2; i >= 0; i--) {
            int now = dis(pt[i], pt[i + 1]);
            disR[i] = disR[i + 1] + now;
        }
        ans = disR[0];
        for(int i = 1; i < n - 1; i++) {
            int now = disL[i - 1] + disR[i + 1] + dis(pt[i - 1], pt[i + 1]);
            ans = Math.min(ans, now);
        }

        System.out.print(ans);
    }
    static int dis(pair a, pair b) {
        int x = a.x - b.x;
        int y = a.y - b.y;
        return Math.abs(x) + Math.abs(y);
    }
    static int find(int[] arr, int n) {
        return merge(arr, 0, arr.length - 1, n);
    }
    static int find2(int[] arr, int n) {
        return merge2(arr, 0, arr.length - 1, n);
    }
    static int merge(int[] arr, int fst, int end, int n) {
        int mid = (fst + end) / 2;
        if(fst == end) {
            if(arr[mid] >= n)
                return mid;
            else
                return mid + 1;
        }
        if(arr[mid] > n && n >= arr[mid + 1]) {
            return mid;
        }
        if(arr[mid] < n) {
            return merge(arr, mid + 1, end, n);
        }
        else {
            return merge(arr, fst, mid, n);
        }
    }
    static int merge2(int[] arr, int fst, int end, int n) {
        int mid = (fst + end) / 2;
        if(fst == end) {
            if(arr[mid] > n)
                return mid - 1;
            else {
                return mid;
            }
        }
        if(arr[mid] <= n && n < arr[mid + 1]) {
            return mid;
        }
        if(arr[mid] < n) {
            return merge2(arr, mid + 1, end, n);
        }
        else {
            return merge2(arr, fst, mid, n);
        }
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



