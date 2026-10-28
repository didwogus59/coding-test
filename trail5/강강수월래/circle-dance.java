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

        for(int i = 0; i < m; i++) {
            int cnt = sc.nextInt();
            int val = sc.nextInt();
            node fst = new node(val);
            node now = fst;
            map.put(val, now);
            for(int j = 1; j < cnt; j++) {
                val = sc.nextInt();
                node tmp = new node(val);
                now.nxt = tmp;
                tmp.pre = now;
                now = tmp;
                map.put(val, tmp);
            }
            now.nxt = fst;
            fst.pre = now;
        }

        for(int i = 0; i < q; i++) {
            int cmd = sc.nextInt();
            if(cmd == 1) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                node na = map.get(a);
                node nb = map.get(b);

                node ta = na.nxt;
                node tb = nb.pre;
                na.nxt = nb;
                nb.pre = na;

                tb.nxt = ta;
                ta.pre = tb;
            }
            else if(cmd == 2) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                node na = map.get(a);
                node nb = map.get(b);

                node ta = na.pre;
                node tb = nb.pre;

                na.pre = tb;
                tb.nxt = na;

                ta.nxt = nb;
                nb.pre = ta;
            }
            else {
                int a = sc.nextInt();

                node now = map.get(a);
                now = now.nxt;
                int min = a;
                while(now.val != a) {
                    min = Math.min(min, now.val);
                    now = now.nxt;
                }
                node st = map.get(min);
                st = st.pre;
                sb.append(min).append(" ");

                while(st.val != min) {
                    sb.append(st.val).append(" ");
                    st = st.pre;
                }
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