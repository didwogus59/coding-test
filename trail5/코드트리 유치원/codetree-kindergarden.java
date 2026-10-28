import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class Main {
    static int ans = 0;
    //    static int[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, node> map = new HashMap<>();
        StringBuffer sb = new StringBuffer();
        int n = sc.nextInt();
        int last = 2;
        map.put(1, new node(1));
        for(int i = 0; i < n; i++) {
            int cmd = sc.nextInt();
            if(cmd == 1) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                node fst = new node(last);
                map.put(last, fst);
                node now = fst;
                last++;
                for(int j = 1; j < b; j++) {
                    node tmp = new node(last);
                    map.put(last, tmp);
                    last++;
                    now.nxt = tmp;
                    tmp.pre = now;
                    now = tmp;
                }
                node left = map.get(a);
                node right = left.nxt;
                left.nxt = fst;
                fst.pre = left;
                if(right != null) {
                    now.nxt = right;
                    right.pre = now;
                }
            }
            else if(cmd == 2) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                node fst = new node(last);
                map.put(last, fst);
                node now = fst;
                last++;
                for(int j = 1; j < b; j++) {
                    node tmp = new node(last);
                    map.put(last, tmp);
                    last++;
                    now.nxt = tmp;
                    tmp.pre = now;
                    now = tmp;
                }
                node right = map.get(a);
                node left = right.pre;
                right.pre = now;
                now.nxt = right;
                if(left != null) {
                    left.nxt = fst;
                    fst.pre = left;
                }
            }
            else {
                int val = sc.nextInt();
                node now = map.get(val);
                if(now.pre != null && now.nxt != null)
                    sb.append(now.pre.val).append(" ").append(now.nxt.val).append("\n");
                else 
                    sb.append("-1\n");
            }
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



