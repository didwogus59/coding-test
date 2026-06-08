import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int ans = Integer.MIN_VALUE;
    static int[] num;
    static int[] cal;
    static int[] real;
    static int len;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int max = sc.nextInt();
        int[] arr = new int[max];
        bt(arr,0, max, num);
    }
    static void bt(int[] arr,int now, int max, int num) {
        if(now == max) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < max; i++) {
                sb.append(arr[i]);
                sb.append(' ');
            }
            sb.append('\n');
            System.out.print(sb);
        }
        else {
            for(int i = 1; i <= num; i++) {
                if(now >= 2)
                    if(arr[now - 2] == arr[now - 1] && arr[now - 1] == i)
                        continue;

                arr[now] = i;
                bt(arr, now + 1, max, num);
            }
        }
    }
}


