import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fact(n));
    }

    public static int fact(int n) {
        if(n == 1)
            return 0;
        else {
            if(n % 2 == 0) {
                return 1 + fact(n/2);
            }
            else
                return 1 + fact(n * 3 + 1);
        }
    }
}