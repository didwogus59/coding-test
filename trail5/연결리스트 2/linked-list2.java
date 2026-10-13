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
        for(int i = 0; i < n; i++) {
            map.put(i + 1, new node(i + 1));
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < m; i++) {
            int cmd = sc.nextInt();
            if(cmd == 1) {
                int tmp = sc.nextInt();
                node now = map.get(tmp);
                now.del();
            }
            else if(cmd == 2) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                node main = map.get(a);
                node put = map.get(b);

                if(main.nxt != null) {
                    put.nxt = main.nxt;
                    main.nxt.pre = put;
                }
                main.nxt = put;
                put.pre = main;
            }
            else if(cmd == 3) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                node main = map.get(a);
                node put = map.get(b);


                if(main.pre != null) {
                    put.pre = main.pre;
                    main.pre.nxt = put;
                }
                main.pre = put;
                put.nxt = main;
            }
            else {
                int tmp = sc.nextInt();

                node now = map.get(tmp);
                int a = now.pre != null ? now.pre.val : 0;
                int b = now.nxt != null ? now.nxt.val : 0;
                sb.append(b).append(" ").append(a).append("\n");
            }
        }
        for(int i = 0; i < n; i++) {
            node now = map.get(i + 1);
            int tmp = now.pre != null ? now.pre.val : 0;
            sb.append(tmp).append(" ");
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

    }

}



