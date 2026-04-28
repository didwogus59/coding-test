import java.util.*;
public class Main {
    static int[] mx = {0, 1, 0, -1};
    static int[] my = {1, 0, -1, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> list = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            list.add(tmp);
        }
        boolean chk = true;
        while(chk && list.size() > 0) {
            chk = false;
            int idx = 0;
            int fst = 0;
            int bef = list.get(0);
            int len = 0;
            for(int i : list) {
                if(i == bef) {
                    len++;
                }
                else {
                    if(len >= m) {
                        chk = true;
                        break;
                    }
                    fst = idx;
                    bef = i;
                    len = 1;
                }
                idx++;
            }
            if(len >= m)
                chk = true;
            if(chk) {
                for(int i = 0; i < len; i++) {
                    list.remove(fst);
                }
            }
        }
        System.out.println(list.size());
        for(int i : list) {
            System.out.println(i);
        }
    }
    static boolean inRange(int n, int x, int y) {
        return x >= 0 && y >= 0 & x < n && y < n;
    }
}
/*
4 2
1
2
2
1
* */