import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int ans = 0;
    static int len;
    static int m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[2000001];
        arr[n] = 1;
        Deque<Integer> deq = new ArrayDeque<>();
        deq.add(n);
        while (!deq.isEmpty()) {
            int now = deq.pop();
            if(arr[now] < 30) {
                if(now > 0) {
                    if (arr[now - 1] == 0 || arr[now - 1] > arr[now] + 1) {
                        arr[now - 1] = arr[now] + 1;
                        deq.add(now - 1);
                    }
                }
                if(now < 1000001) {
                    if (arr[now + 1] == 0 || arr[now + 1] > arr[now] + 1) {
                        arr[now + 1] = arr[now] + 1;
                        deq.add(now + 1);
                    }
                }
                if(now % 2 == 0) {
                    if(arr[now / 2] == 0 || arr[now / 2] > arr[now] + 1) {
                        arr[now / 2] = arr[now] + 1;
                        deq.add(now / 2);
                    }
                }
                if(now % 3 == 0) {
                    if(arr[now / 3] == 0 || arr[now / 3] > arr[now] + 1) {
                        arr[now / 3] = arr[now] + 1;
                        deq.add(now / 3);
                    }
                }
            }
        }


        System.out.println(arr[1] - 1);
    }

    static boolean inRange(int x, int y, int lenX, int lenY) {
        return x >= 0 && y >= 0 && x < lenX && y < lenY;
    }
    static class pair {
        int x;
        int y;
        int cnt = 0;
        int now = 0;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public pair(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}


