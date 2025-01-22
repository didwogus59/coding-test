import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fact(n));
    }
    public static int fact(int n) {
        if(n == 1) {
            return 0;
        }
        else {
            if(n % 2 == 0) {
                n /= 2;
            }
            else {
                n /= 3;
            }
            return fact(n) + 1;
        }
    }
}