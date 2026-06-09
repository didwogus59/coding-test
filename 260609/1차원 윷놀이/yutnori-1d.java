import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int ans = Integer.MIN_VALUE;
    static int len;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int turn = sc.nextInt();
        len = sc.nextInt() - 1;
        int chip = sc.nextInt();

        int[] turns = new int[turn];
        int[] chips = new int[chip];

        for(int i = 0; i < turn; i++) {
            turns[i] = sc.nextInt();
        }
        bt(turns,chips, 0,0,chip, turn);
        System.out.println(ans);
    }
    static void bt(int[] turns,int[] chips, int cnt,int reach,int chip, int turn) {
        if(cnt == turn) {
            if(reach > ans)
                ans = reach;
        }
        else {
            for(int i = 0; i < chip; i++) {
                chips[i] += turns[cnt];
                if (chips[i] >= len && chips[i] - turns[cnt] < len) {
                    bt(turns, chips, cnt + 1, reach + 1, chip, turn);
                }
                else {
                    bt(turns, chips, cnt + 1, reach, chip, turn);
                }
                chips[i] -= turns[cnt];

            }

        }
    }
}


