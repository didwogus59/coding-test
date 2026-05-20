import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int size = sc.nextInt();
        int drop = sc.nextInt() - 1;


        int[][] arr = new int[len][len];

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        boolean chk = true;
        int max = len - 1;
        for(int y = 0; y < size; y++) {
            for(int x = 0; x < len; x++) {
                if(arr[x][drop + y] == 1) {
                    if(max > x - 1)
                        max = x - 1;
                    break;
                }
            }
        }
        for(int y = 0; y < size; y++) {
            arr[max][drop + y] = 1;
        }

        for(int x = 0; x < len; x++) {
            for(int y = 0; y < len; y++) {
                System.out.printf("%d ", arr[x][y]);
            }
            System.out.println();
        }

    }

}


