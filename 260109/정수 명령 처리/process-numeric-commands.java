import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        List<Integer> list = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            String cmd = sc.next();
            
            if("push".equals(cmd)) {
                int num = sc.nextInt();
                list.add(num);
            }
            else if("pop".equals(cmd)) {
                System.out.println(list.get(list.size() - 1));
                list.remove(list.size() - 1);
            }
            else if("size".equals(cmd)) {
                System.out.println(list.size());
            }
            else if("empty".equals(cmd)) {
                if(list.isEmpty()) {
                    System.out.println("1");
                }
                else {
                    System.out.println("0");
                }
            }
            else if("top".equals(cmd)) {
                System.out.println(list.get(list.size() - 1));
            }

        }
    }
}