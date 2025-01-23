import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        int n = sc.nextInt();
        int x = 0;
        int y = 0;
        for(int i = 0; i < n; i++) {
            char c = sc.next().charAt(0);
            int l = sc.nextInt();
            int dir;
            if(c == 'N') {
                dir = 0;
            }
            else if(c == 'E') {
                dir = 1;
            }
            else if(c == 'S') {
                dir = 2;
            }
            else {
                dir = 3;
            }
            x += (l * dx[dir]);
            y += (l * dy[dir]);
        }
        System.out.printf("%d %d",y,x);
        
    }
}