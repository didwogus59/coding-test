import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        List<LinkedList<Integer>> lists = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            lists.add(new LinkedList<>());
        }
        int t = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int tmp = sc.nextInt();
                lists.get(i).add(tmp);
            }
        }

        for(int i = 0; i < t; i++) {
            int line = sc.nextInt() - 1;
            String dirS = sc.nextLine();
            int dir = " L".equals(dirS) ? 1 : -1;
            move(dir, lists.get(line));

            int up = line - 1;
            int down = line + 1;
            int dirU = dir * -1;
            int dirD = dir * -1;
            while(up >= 0) {
                if( comp(lists.get(up), lists.get(up + 1))) {
                    move(dirU, lists.get(up));
                    up--;
                    dirU *= -1;
                }
                else
                    break;
            }
            while(down < n) {
                if(comp(lists.get(down), lists.get(down - 1))) {
                    move(dirD, lists.get(down));
                    down++;
                    dirD *= -1;
                }
                else
                    break;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int num : lists.get(i)) {
                System.out.printf("%d ", num);
            }
            System.out.println();
        }

    }

    public static void move(int dir, LinkedList<Integer> line) {
        if(dir > 0) {
            int tmp = line.getLast();
            line.removeLast();
            line.addFirst(tmp);
        }
        else {
            int tmp = line.getFirst();
            line.removeFirst();
            line.addLast(tmp);
        }
    }

    static boolean comp(LinkedList<Integer> line1, LinkedList<Integer> line2) {
        int now = 0;
        while(now < line1.size()) {
            if(line1.get(now) == line2.get(now)) {
                return true;
            }
            now++;
        }
        return false;
    }
}