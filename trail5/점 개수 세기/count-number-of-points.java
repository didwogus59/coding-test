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
        Map<Integer, Integer> mapX = new HashMap<>();
        Map<Integer, Integer> mapY = new HashMap<>();
        StringBuffer sb = new StringBuffer();
        Set<Integer> setX = new HashSet<>();
        Set<Integer> setY = new HashSet<>();
        n = sc.nextInt();
        k = sc.nextInt();

        int[] num = new int[n];
        for(int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        Arrays.sort(num);
        for(int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n1 = find(num, a);
            int n2 = find2(num, b);
            sb.append(n2 - n1 + 1).append("\n");
        }
        System.out.print(sb);
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



