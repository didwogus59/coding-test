import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int ans = 0;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        Map<Character, Integer> map = new HashMap<>();

        String tmp = sc.next();
        char ans = '0';
        for(int i = 0; i < tmp.length(); i++) {
            char c = tmp.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < tmp.length(); i++) {
            char c = tmp.charAt(i);
            if(map.get(c) == 1) {
                ans = c;
                break;
            }
        }
        if(ans == '0')
            System.out.println("None");
        else
            System.out.println(ans);
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


