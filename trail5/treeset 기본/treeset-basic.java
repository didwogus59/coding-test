import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class Main {
    static int ans = 0;
    //    static int[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<>();

        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            String tmp = sc.next();
            if("add".equals(tmp)) {
                int now = sc.nextInt();
                set.add(now);
            }
            else if("remove".equals(tmp)) {
                int now = sc.nextInt();
                set.remove(now);
            }

            else if("find".equals(tmp)) {
                int now = sc.nextInt();
                if(set.contains(now)) {
                    System.out.println("true");
                }
                else {
                    System.out.println("false");
                }
            }

            else if("lower_bound".equals(tmp)) {
                int now = sc.nextInt();
                if(set.ceiling(now) != null)
                    System.out.println(set.ceiling(now));
                else
                    System.out.println("None");
            }

            else if("upper_bound".equals(tmp)) {
                int now = sc.nextInt();
                if(set.higher(now) != null)
                    System.out.println(set.higher(now));
                else
                    System.out.println("None");
            }

            else if("largest".equals(tmp)) {
                if(set.isEmpty())
                    System.out.println("None");
                else
                    System.out.println(set.last());
            }
            else {
                if(set.isEmpty())
                    System.out.println("None");
                else
                    System.out.println(set.first());
            }
        }
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



