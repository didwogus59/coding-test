import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int len = Integer.parseInt(st.nextToken());
        int[][] arr = new int[len][len];

        int boom = Integer.parseInt(st.nextToken());

        int count = Integer.parseInt(st.nextToken());

        for(int i = 0; i < len; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < len; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int cnt = 0; cnt < count + 1; cnt++) {
            boolean boomed = true;
            while(boomed) {
                boomed = false;
                for (int y = 0; y < len; y++) {
                    int bef = arr[0][y];
                    int size = 1;
                    if(bef == 0)
                        size = 0;
                    for (int x = 1; x < len; x++) {
                        if(arr[x][y] == 0)
                            continue;
                        if (arr[x][y] == bef) {
                            size++;
                        } else {
                            if (size >= boom) {
                                int nx = x - 1;
                                while (size > 0) {
                                    boomed = true;
                                    if(arr[nx][y] != 0)
                                        size--;
                                    arr[nx][y] = 0;
                                    nx--;
                                }

                            }
                            bef = arr[x][y];
                            size = 1;
                        }
                    }
                    if (size >= boom) {
                        int nx = len - 1;
                        while (size > 0) {
                            boomed = true;
                            if(arr[nx][y] != 0)
                                size--;
                            arr[nx][y] = 0;
                            nx--;
                        }
                    }
                }
            }
            for(int y = 0; y < len; y++) {
                int befX = len - 1;
                for(int x = len - 1; x >= 0; x--) {
                    if(arr[x][y] != 0) {
                        int tmp = arr[x][y];
                        arr[x][y] = 0;
                        arr[befX][y] = tmp;
                        befX--;
                    }
                }
            }

            int[][] tmp = new int[len][len];
            for(int y = 0; y < len; y++) {
                for(int x = 0; x < len; x++) {
                    tmp[y][len - 1 - x] = arr[x][y];
                }
            }
            arr = tmp;

            for(int y = 0; y < len; y++) {
                int befX = len - 1;
                for(int x = len - 1; x >= 0; x--) {
                    if(arr[x][y] != 0) {
                        int tmpN = arr[x][y];
                        arr[x][y] = 0;
                        arr[befX][y] = tmpN;
                        befX--;
                    }
                }
            }
        }

        int ans = 0;
        for(int[] i : arr) {
            for(int j : i) {
                if(j != 0) {
                    ans += 1;
                }
            }
        }
        System.out.printf("%d", ans);
    }
}


