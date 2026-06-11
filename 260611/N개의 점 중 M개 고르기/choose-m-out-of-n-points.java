import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int ans = Integer.MAX_VALUE;
    static int len;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        len = sc.nextInt();
        int max = sc.nextInt();
        pair[] arr =new pair[len];

        for(int i = 0; i < len; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[i] = new pair(x,y);
        }
        Deque<pair> deq = new ArrayDeque<>();
        bt(arr,deq, 0, 0, 0, max);
        System.out.println(ans);
    }
    static void bt(pair[] arr, Deque<pair> deq, int now, int cnt,int dis, int max) {
            if (cnt == max) {
                if (ans > dis)
                    ans = dis;
            }
            else {
                if(now < len) {
                    int maxD = dis;
                    for (pair p : deq) {
                        int d = dis(p, arr[now]);
                        maxD = Math.max(d, maxD);
                    }
                    deq.push(arr[now]);
                    bt(arr, deq, now + 1, cnt + 1, maxD, max);
                    deq.pop();
                    bt(arr, deq, now + 1, cnt, dis, max);
                }
            }
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < len && y < len;
    }
    static int dis(pair p1, pair p2) {
        int dx = p1.x - p2.x;
        int dy = p1.y - p2.y;
        return dx * dx + dy * dy;
    }
    static int dis(int x, int y, int nx, int ny) {
        int dx = nx - x;
        int dy = ny - y;
        dx = dx > 0 ? dx : (dx * -1);
        dy = dy > 0 ? dy : (dy * -1);
        return dx + dy;
    }

    static class pair {
        public int x;
        public int y;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}


