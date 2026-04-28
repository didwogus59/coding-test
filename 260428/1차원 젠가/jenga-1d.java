import java.util.*;
public class Main {
    static int[] mx = {0, 1, 0, -1};
    static int[] my = {1, 0, -1, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        List<Integer> list = new LinkedList<>();

        for(int i = 0; i < len; i++) {
            int tmp = sc.nextInt();
            list.add(tmp);
        }
        int r1 = sc.nextInt() - 1;
        int c1 = sc.nextInt() - 1;

        int r2 = sc.nextInt() - 1;
        int c2 = sc.nextInt() - 1;

        for(int i = r1; i <= c1; i++) {
            list.remove(r1);
        }
        for(int i = r2; i <= c2; i++) {
            list.remove(r2);
        }
        System.out.println(list.size());
        for(int i : list) {
            System.out.println(i);
        }
    }
}
/*
*
*
*
6
1
2
3
1
1
5
2 4
2 2
*
*
*
* */