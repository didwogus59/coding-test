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
        node fst = new node(0);
        node cur = fst;
        for(int i = 0; i < n; i++) {
            node tmp = new node(i + 1);
            cur.nxt = tmp;
            tmp.pre = cur;
            cur = tmp;
            map.put(i + 1, tmp);
        }
        for(int i = 0; i < m; i++) {
            int s1 = sc.nextInt();
            int e1 = sc.nextInt();
            int s2 = sc.nextInt();
            int e2 = sc.nextInt();

            node ns1 = map.get(s1);
            node ne1 = map.get(e1);

            node ns2 = map.get(s2);
            node ne2 = map.get(e2);
            
            node tmp = ne1.nxt;
            ne1.nxt = ne2.nxt;
            if(ne2.nxt != null) {
                ne2.nxt.pre = ne1;
            }
            ne2.nxt = tmp;
            if(tmp != null)
                tmp.pre = ne2;

            tmp =  ns1.pre;
            ns1.pre = ns2.pre;
            if(ns2.pre != null) {
                ns2.pre.nxt = ns1;
            }

            ns2.pre = tmp;
            if(tmp != null)
                tmp.nxt = ns2;
        }
        cur = fst.nxt;
        StringBuffer sb = new StringBuffer();
        while(cur != null) {
            sb.append(cur.val).append(" ");
            cur = cur.nxt;
        }
        System.out.print(sb);

    }
    static class node {
        node pre = null;
        node nxt = null;
        public int val;

        public node(int v) {
            this.val = v;
        }
        void del() {
            if(this.pre != null) {
                this.pre.nxt = this.nxt;
            }
            if(this.nxt != null) {
                this.nxt.pre = this.pre;
            }
            this.pre = this.nxt = null;
        }

        void add_head(int v) {
            node now = new node(v);
            if(this.nxt != null) {
                node tmp = this.nxt;
                now.nxt = tmp;
                tmp.pre = now;
            }
            this.nxt = now;
            now.pre = this;
        }

        void add_tail(int v) {
            node now = new node(v);
            if(this.pre != null) {
                node tmp = this.pre;
                now.pre = tmp;
                tmp.nxt = now;
            }
            this.pre = now;
            now.nxt = this;
        }
        void chg(node tg) {
            node tmp = tg.nxt;
            tg.nxt = this.nxt;
            if(this.nxt != null) {
                this.nxt.pre = tg;
            }
            this.nxt = tmp;
            if(tmp != null)
                tmp.pre = this;

            tmp = tg.pre;
            tg.pre = this.pre;
            if(this.pre != null) {
                this.pre.nxt = tg;
            }

            this.pre = tmp;
            if(tmp != null)
                tmp.nxt = this;


        }
    }

}



