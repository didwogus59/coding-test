import java.util.*;
public class Main {
    static int[] mx = {0, 1, 0, -1};
    static int[] my = {1, 0, -1, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int len = str.length();
        int[] arr = new int[len];
        for(int i = 0; i < len; i++) {
            arr[i] = str.charAt(i);
        }
        int ans = len * 2;
        for(int i = 0; i < len; i++) {
            int cnt = 1;
            int sum = 0;
            int bef = arr[i];
            for(int j = 1; j < len; j++) {
                int now = (i + j) % len;
                if(arr[now] == bef) {
                    cnt++;
                }
                else {
                    sum = sum + 1 + digit(cnt);
                    cnt = 1;
                }
                bef = arr[now];
            }
            sum = sum + 1 + digit(cnt);
            if(sum < ans)
                ans = sum;
        }
        System.out.println(ans);

    }
    static int digit(int num) {
        int cnt = 1;
        while(num >= 10) {
            cnt++;
            num /= 10;
        }
        return cnt;
    }
}
