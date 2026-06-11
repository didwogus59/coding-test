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
        int[] arr = new int[len * 2];
        for(int i = 0; i < len * 2; i++) {
            arr[i] = sc.nextInt();
        }
        bt(arr, 0, 0, 0,0,0);

        System.out.println(ans);
    }
    static void bt(int[] arr,int sum1, int sum2,int cnt1, int cnt2, int now) {
        if(now == arr.length) {
            int diff = sum1 - sum2;
            diff = diff > 0 ? diff : (-1 * diff);
            if(ans > diff)
                ans = diff;
        }
        else {
            int max = arr.length / 2;
            if(cnt1 < max)
                bt(arr, sum1 + arr[now], sum2, cnt1 + 1, cnt2, now + 1);
            if(cnt2 < max)
                bt(arr, sum1, sum2 + arr[now], cnt1, cnt2 + 1, now + 1);
        }
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < len && y < len;
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


