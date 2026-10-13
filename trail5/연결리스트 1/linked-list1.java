import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class Main {
    static int ans = 0;
    //    static int[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String init = sc.next();
        node cur = new node(init);

        int n = sc.nextInt();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < n; i++) {
            int cmd = sc.nextInt();
            if(cmd == 1) {
                String tmp = sc.next();
                cur.add_head(tmp);
            }
            else if(cmd == 2) {
                String tmp = sc.next();
                cur.add_tail(tmp);
            }
            else if(cmd == 4) {
                if(cur.pre != null) {
                    cur = cur.pre;
                }
            }
            else {
                if(cur.nxt != null) {
                    cur = cur.nxt;
                }
            }
            String a = cur.nxt != null ? cur.nxt.val : "(Null)";
            String b = cur != null ? cur.val : "(Null)";
            String c = cur.pre != null ? cur.pre.val : "(Null)";
            sb.append(a).append(" ").append(b).append(" ").append(c).append("\n");

        }
    System.out.print(sb);
    }
    static class node {
        node pre = null;
        node nxt = null;
        public String val;

        public node(String v) {
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

        void add_head(String v) {
            node now = new node(v);
            if(this.nxt != null) {
                node tmp = this.nxt;
                now.nxt = tmp;
                tmp.pre = now;
            }
            this.nxt = now;
            now.pre = this;
        }

        void add_tail(String v) {
            node now = new node(v);
            if(this.pre != null) {
                node tmp = this.pre;
                now.pre = tmp;
                tmp.nxt = now;
            }
            this.pre = now;
            now.nxt = this;
        }

    }

}



