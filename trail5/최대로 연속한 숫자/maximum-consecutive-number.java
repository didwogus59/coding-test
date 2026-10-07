import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class Main {
    static int ans = 0;
    //    static int[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        TreeSet<pair> dis = new TreeSet<>();
        TreeSet<pair> set = new TreeSet<>();
        set.add(new pair(-1, n + 1));
        dis.add(new pair(n + 2, -1));
        ans = 0;
        for(int i = 0; i < m; i++) {
            int now = sc.nextInt();
            pair tmp = set.lower(new pair(now, 0));
            int min = tmp.x;
            int max = tmp.y;
            set.remove(tmp);
            set.add(new pair(min, now));
            set.add(new pair(now, max));
            dis.remove(new pair(max - min, min));
            dis.add(new pair(now - min, min));
            dis.add(new pair(max - now, now));
            System.out.println(dis.last().x - 1);
        }
    }
    static class pair implements Comparable<pair>{
        public int x;
        public int y;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(pair p) {
            if(this.x != p.x) {
               return this.x - p.x;
            }
            else
                return this.y - p.y;
        }
    }

}



