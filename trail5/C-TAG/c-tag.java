import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int ans = 0;
//    static int[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        int[][] arr2 = new int[n][m];
        for(int i = 0; i < n; i++) {
            String tmp = sc.next();
            for(int j = 0; j < m; j++) {
                char tmpC = tmp.charAt(j);
                if(tmpC == 'A')
                    arr[i][j] = 1;
                else if(tmpC == 'T')
                    arr[i][j] = 2;
                else if(tmpC == 'G')
                    arr[i][j] = 3;
                else 
                    arr[i][j] = 4;
            }
        }
        for(int i = 0; i < n; i++) {
            String tmp = sc.next();
            for(int j = 0; j < m; j++) {
                char tmpC = tmp.charAt(j);
                if(tmpC == 'A')
                    arr2[i][j] = 1;
                else if(tmpC == 'T')
                    arr2[i][j] = 2;
                else if(tmpC == 'G')
                    arr2[i][j] = 3;
                else
                    arr2[i][j] = 4;
            }
        }
        ans = 0;
        for(int i = 0; i < m; i++) {
            for(int j = i + 1; j < m; j++) {
                for(int p = j + 1; p < m; p++) {
                    Set<Integer> set = new TreeSet<>();
                    Set<Integer> set2 = new TreeSet<>();
                    for(int q = 0; q < n; q++) {
                        set.add(arr[q][i] * 100 + arr[q][j] * 10 + arr[q][p]);
                        set2.add(arr2[q][i] * 100 + arr2[q][j] * 10 + arr2[q][p]);
                    }
                    boolean chk = true;
                    for(int tmp : set) {
                        if(set2.contains(tmp)) {
                            chk = false;
                            break;
                        }
                    }
                    if(chk)
                        ans++;
                }
            }
        }
        System.out.print(ans);
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


