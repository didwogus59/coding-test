import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Integer> que1 = new LinkedList<>();

        Queue<Integer> que2 = new LinkedList<>();

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] tmp = new int[n];

        for(int i = 0; i < n; i++) {
            tmp[i] = sc.nextInt();
        }
        for(int i = n - 1; i >= 0; i--) {
            que1.add(tmp[i]);
        }

        for(int i = 0; i < n; i++) {
            tmp[i] = sc.nextInt();
        }
        for(int i = n - 1; i >= 0; i--) {
            que2.add(tmp[i]);
        }
        for(int i = 0; i < m; i++) {
            que1.add(que2.poll());
            que2.add(que1.poll());
        }

        for(int i = n - 1; i >= 0; i--) {
            tmp[i] = que1.poll();
        }
        for(int i = 0; i < n; i++) {
            System.out.printf("%d ", tmp[i]);
        }
        System.out.println();
        for(int i = n - 1; i >= 0; i--) {
            tmp[i] = que2.poll();
        }
        for(int i = 0; i < n; i++) {
            System.out.printf("%d ", tmp[i]);
        }
    }
}