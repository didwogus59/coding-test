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
        int m = sc.nextInt();
        int q = sc.nextInt();
        node[] head = new node[m];
        node[] tail = new node[m];
        
        for(int i = 0; i < m; i++) {
            int cnt = sc.nextInt();
            
            head[i] = new node(0);
            tail[i] = head[i];
            for(int j = 0; j < cnt; j++) {
                int val = sc.nextInt();
                node now = new node(val);
                tail[i].nxt = now;
                now.pre = tail[i];
                tail[i] = now;
                map.put(val, now);
            }
        }
        
        for(int i = 0; i < q; i++) {
            int cmd = sc.nextInt();
            if(cmd == 1) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                
                node na = map.get(a);
                node nb = map.get(b);
                
                if(na.nxt != null) {
                    na.nxt.pre = na.pre;
                }
                na.pre.nxt = na.nxt;
                
                nb.pre.nxt = na;
                na.pre = nb.pre;
                na.nxt = nb;
                nb.pre = na;
            }
            else if(cmd == 2) {
                int a = sc.nextInt();
                node now = map.get(a);
                node left = now.pre;
                node right = now.nxt;
                if(right != null) {
                    right.pre = left;
                }
                left.nxt = right;
                now.nxt = null;
                now.pre = null;
            }
            else {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                
                node na = map.get(a);
                node nb = map.get(b);
                node nc = map.get(c);
                
                if(nb.nxt != null) {
                    nb.nxt.pre = na.pre;
                }
                na.pre.nxt = nb.nxt;

                nc.pre.nxt = na;
                na.pre = nc.pre;
                nb.nxt = nc;
                nc.pre = nb;
            }
        }
        
        for(int i = 0; i < m; i++) {
            node now = head[i].nxt;
            if(now == null) {
                sb.append("-1");
            }
            while(now != null) {
                sb.append(now.val).append(" ");
                now = now.nxt;
            }
            sb.append("\n");
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



