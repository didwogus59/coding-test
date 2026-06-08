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
        String tmp = sc.next();
        int aNum = 'a';
        aNum -= 1;
        int size = tmp.length();
        num = new int[size];
        real = new int[40];
        cal = new int[size];

        for(int i = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i) == '+') {
                cal[i] = 1;
            } else if (tmp.charAt(i) == '-') {
                cal[i] = 2;
            } else if (tmp.charAt(i) == '*') {
                cal[i] = 3;
            } else {
                int cNum = tmp.charAt(i);
                num[i] = cNum - aNum;
            }
        }

        for(int i = 1; i <= 4; i++) {
            real[num[0]] = i;
            bt(1, size, i);
        }
        System.out.println(ans);
    }
    static void bt(int now, int max, int result) {
        if(now >= max) {
            if(result > ans) {
                ans = result;
            }
        }
        else {
            int n = num[now + 1];
            int nxt = real[n];
            if(real[n] == 0) {
                for(int i = 1; i < 5; i++) {
                    real[n] = i;
                    bt(now + 2, max, calNum(result, real[n], cal[now]));
                    real[n] = 0;
                }
            }
            else {
                bt(now + 2, max, calNum(result, nxt, cal[now]));
            }
        }
    }
    static int calNum(int a, int b, int c) {
        if(c == 1) {
            return a + b;
        }
        if(c == 2) {
            return a - b;
        }
        return a * b;
    }
}


