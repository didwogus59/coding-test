import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class Main {
    static int ans = 0;
    //    static int[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, node> map = new HashMap<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int val = sc.nextInt();
        node fst = new node(val);
        node now = fst;
        map.put(val, fst);
        for(int i = 1; i < n; i++) {
            val = sc.nextInt();
            node tmp = new node(val);
            map.put(val, tmp);
            now.nxt = tmp;
            tmp.pre = now;
            now = tmp;
        }
        now.nxt = fst;
        fst.pre = now;
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < m; i++) {
            val = sc.nextInt();
            now = map.get(val);
            node lft = now.pre;
            node rht = now.nxt;

            sb.append(rht.val).append(" ").append(lft.val).append("\n");

            lft.nxt = rht;
            rht.pre = lft;
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



