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
        node[] heads = new node[m];
        node[] tails = new node[m];
        heads[0] = new node(1);
        tails[0] = heads[0];
        heads[0].pre = null;
        tails[0].nxt = null;
        for(int i = 1; i < n; i++) {
            node tmp = new node(i + 1);
            tails[0].nxt = tmp;
            tmp.pre = tails[0];
            tails[0] = tmp;
        }
        int q = sc.nextInt();

        for(int i = 0; i < q; i++) {
            int cmd = sc.nextInt();
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            if(cmd == 1) {
                if(heads[a] != null) {
                    node tmp = heads[a];
                    if(heads[a].val != tails[a].val) {
                        heads[a] = heads[a].nxt;
                        heads[a].pre = null;
                    }
                    else {
                        heads[a] = null;
                        tails[a] = null;
                    }
                    tmp.pre = null;
                    tmp.nxt = null;
                    if(heads[b] == null) {
                        heads[b] = tmp;
                        tails[b] = tmp;
                    }
                    else {
                        tails[b].nxt = tmp;
                        tmp.pre = tails[b];
                        tails[b] = tmp;
                    }
                }
            }
            else if(cmd == 2) {
                if(heads[a] != null) {
                    node tmp = tails[a];
                    if(heads[a].val != tails[a].val) {
                        tails[a] = tails[a].pre;
                        tails[a].nxt = null;
                    }
                    else {
                        heads[a] = null;
                        tails[a] = null;
                    }
                    tmp.pre = null;
                    tmp.nxt = null;
                    if(heads[b] == null) {
                        heads[b] = tmp;
                        tails[b] = tmp;
                    }
                    else {
                        heads[b].pre = tmp;
                        tmp.nxt = heads[b];
                        heads[b] = tmp;
                    }
                }
            }
            else if(cmd == 3) {
                if(heads[a] != null) {
                    node tmpH = heads[a];
                    node tmpT = tails[a];

                    heads[a] = null;
                    tails[a] = null;

                    if(heads[b] != null) {
                        tmpT.nxt = heads[b];
                        heads[b].pre = tmpT;
                        heads[b] = tmpH;
                    }
                    else {
                        heads[b] = tmpH;
                        tails[b] = tmpT;
                    }
                }
            }
            else {
                if(heads[a] != null) {
                    node tmpH = heads[a];
                    node tmpT = tails[a];

                    heads[a] = null;
                    tails[a] = null;

                    if(heads[b] != null) {
                        tails[b].nxt = tmpH;
                        tmpH.pre = tails[b];
                        tails[b] = tmpT;
                    }
                    else {
                        heads[b] = tmpH;
                        tails[b] = tmpT;
                    }
                }
            }
        }

        for(int p = 0; p < m; p++) {
            int cnt = 0;
            node cur = heads[p];
            StringBuffer sb = new StringBuffer();
            while(cur != null)
            {
                cnt++;
                sb.append(cur.val).append(" ");
                cur = cur.nxt;
            }
            sb.append("\n");
            System.out.printf("%d ",cnt);
            System.out.print(sb);

        }
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



