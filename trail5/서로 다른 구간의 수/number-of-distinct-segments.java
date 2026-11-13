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
        pair[] p = new pair[n];
        pair[] arr = new pair[n*2];
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            p[i] = new pair(a, b);
            arr[i] = new pair(a, 1, i);
            arr[i + n] = new pair(b, -1, i);
        }
        Arrays.sort(arr);
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < n *2; i++) {
            pair tmp = arr[i];
            int pt = tmp.x;
            int edge = tmp.y;
            int idx = tmp.z;
            
            if(set.isEmpty()) {
                ans++;
            }
            if(edge == -1) {
                set.remove(idx);
            }
            else {
                set.add(idx);
            }
        }

        System.out.println(ans);
    }


    static class pair implements Comparable<pair>{
        int x;
        int y;
        int z;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public pair(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
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



