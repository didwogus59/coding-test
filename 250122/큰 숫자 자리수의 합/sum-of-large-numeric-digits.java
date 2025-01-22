import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n1 = sc.nextLong();
        long n2 = sc.nextLong();
        long n3 = sc.nextLong();

        long mul = n1 * n2 * n3;
        System.out.println(fact(mul));
    }
    public static long fact(long n) {
        if(n == 0L)
            return 0;
        return n % 10L + fact(n / 10L);
    }
}