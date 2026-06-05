import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        bt(n,0);
        System.out.println(ans);
    }

    static void bt(int n, int cnt) {
        if(cnt == n) {
            ans++;
        }
        else if(cnt < n){
            for(int i = 1; i <= 4; i++) {
                bt(n, cnt + i);
            }
        }
    }

}


