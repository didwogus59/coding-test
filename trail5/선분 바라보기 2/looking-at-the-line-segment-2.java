import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class Main {
    //    static int[] arr;
//    static int[][] sum;
    static int n;
    static int k;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        n = sc.nextInt();
//        k = sc.nextInt();
        TreeSet<pair> set = new TreeSet<>();

        pair[] p = new pair[n * 2];
        for(int i = 0; i < n; i++) {
            int y = sc.nextInt() + 1000000001;
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();

            p[i] = new pair(x1, y, i);
            p[i + n] = new pair(x2, -y, i);
        }
        Arrays.sort(p);
        int[] chk = new int[n];
        int[] sum = new int[n * 2];
        sum[0] = 1;
        int cnt = 1;
        set.add(new pair(p[0].y, p[0].z));
        chk[p[0].z] = 1;
        for(int i = 1; i < n * 2; i++) {
            int now = p[i].y;
            int peek = 0;

            if(sum[i-1] != 0)
                peek = set.first().x;
            if(now > 0) {
                if(sum[i-1] == 0) {
                    if(chk[p[i].z] == 0) {
                        cnt++;
                        chk[p[i].z] = 1;
                    }
                }
                else if (now < peek) {
                    if(chk[p[i].z] == 0) {
                        cnt++;
                        chk[p[i].z] = 1;
                    }
                }
                set.add(new pair(now, p[i].z));
                sum[i] = sum[i-1] + 1;

            }
            else {
                set.remove(new pair(-now, 0));
                sum[i] = sum[i-1] - 1;
                if(now + peek == 0) {
                    if(!set.isEmpty()) {
                        if(chk[set.first().y] == 0) {
                            cnt++;
                            chk[set.first().y] = 1;
                        }
                    }
                }

            }
        }
        System.out.println(cnt);
    }


    static class pair implements Comparable<pair>{
        int x;
        int y;
        int z = 0;
        int idx;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public pair(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
        @Override
        public int compareTo(pair b) {
            if(this.z != b.z) {
//                return this.z - b.z;
            }
            return this.x - b.x;
        }
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



