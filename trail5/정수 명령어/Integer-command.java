import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class Main {
    static int ans = 0;
    //    static int[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {

            int m = sc.nextInt();
            TreeSet<Integer> set = new TreeSet<>();
            for (int j = 0; j < m; j++) {
                String tmp = sc.next();
                if ("I".equals(tmp)) {
                    int now = sc.nextInt();
                    set.add(now);
                } else {
                    int now = sc.nextInt();
                    if (!set.isEmpty()) {
                        if (now == 1) {
                            set.remove(set.last());
                        } else {
                            set.remove(set.first());
                        }
                    }
                }
            }
            if(set.isEmpty()) {
                System.out.println("EMPTY");
            }
            else {
                System.out.printf("%d %d\n",set.last(), set.first());
            }
        }
    }
    static class pair {
        int cnt;
        int n;
        public pair(int cnt, int n) {
            this.cnt = cnt;
            this.n = n;
        }
    }
}



