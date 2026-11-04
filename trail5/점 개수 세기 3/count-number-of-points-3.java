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
        Map<Integer, Integer> map = new HashMap<>();
        StringBuffer sb = new StringBuffer();

        n = sc.nextInt();
        k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        for(int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }


        for(int i = 0; i < k; i++) {
            int b = sc.nextInt();
            int a = sc.nextInt();

            sb.append(map.get(a) - map.get(b) + 1).append("\n");
        }
        System.out.print(sb);
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



