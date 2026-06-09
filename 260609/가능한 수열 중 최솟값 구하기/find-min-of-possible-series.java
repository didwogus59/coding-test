import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static Long ans = Long.MAX_VALUE;
    static int len;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static boolean ansChk = true;
    static int[] tmpA;
    static int[] tmpB;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        len = sc.nextInt();
        int[] arr = new int[len];
        tmpA = new int[len];
        tmpB = new int[len];
        arr[0] = 4;
        bt(arr, 1);
//        System.out.println(ans);
    }
    static void bt(int[] arr,int now) {
        if(ansChk) {
        if(now == len) {
            int num = 0;
            ansChk = false;
            String tmp = "";
            for(int i = 0; i < len; i++) {
                tmp += arr[i];
            }
            System.out.println(tmp);
        }
        else {
            for(int i = 4; i < 7; i++) {
                if(arr[now - 1] != i) {
                    arr[now] = i;
                    boolean chk = true;
                    int cnt = 1;
                    while(now + 1 - cnt * 2 >= 0) {
                        boolean tmp = true;
                        for(int a = 0; a < cnt; a++) {
                            tmpA[a] = arr[now - a];
                            int numf = arr[now - a];
                            int numb = arr[now - cnt - a];
                            if(numf != numb) {
                                tmp = false;
                                break;
                            }
                        }
                        if(tmp)
                            chk = false;
                        cnt++;
                    }
                    if(chk)
                        bt(arr, now + 1);
                }
            }
        }
        }
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < len && y < len;
    }
}


