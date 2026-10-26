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
        String nm = sc.next();
        node fst = new node(nm);
        node now = fst;
        for(int i = 1; i < n; i++) {
            nm = sc.next();
            node tmp = new node(nm);
            now.nxt = tmp;
            tmp.pre = now;
            now = tmp;
        }
        now.nxt = fst;
        fst.pre = now;
        now = fst;
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < m; i++) {
            int cmd = sc.nextInt();

            if(cmd == 2) {
                if(now.pre != null) {
                    now = now.pre;
                }
            }
            else if(cmd == 1) {
                if(now.nxt != null) {
                    now = now.nxt;
                }
            }
            else if(cmd == 3) {
                if(now.nxt != null) {
                    now.nxt = now.nxt.nxt;
                    if(now.nxt != null) {
                        now.nxt.pre = now;
                    }
                }
            }
            else {
                nm = sc.next();
                node tmp = new node(nm);

                if(now.nxt == null) {
                    now.nxt = tmp;
                    tmp.pre = now;
                }
                else {
                    node tmp2 = now.nxt;
                    now.nxt = tmp;
                    tmp.pre = now;
                    tmp.nxt = tmp2;
                    tmp2.pre = tmp;
                }
            }
            if(now.nxt == null || now.pre == null) {
                sb.append(-1).append("\n");
            }
            else if(now.nxt.str.equals(now.pre.str)){
                sb.append(-1).append("\n");
            }
            else {
                sb.append(now.pre.str).append(" ").append(now.nxt.str).append("\n");
            }
        }
        System.out.print(sb);

    }
    static class node {
        node pre = null;
        node nxt = null;
        public int val;
        public String str;
        public node(int v) {
            this.val = v;
        }
        public node(String str) {this.str = str;}
    }

}



