import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            arr[i] = tmp;
        }
        boolean chk = true;
        while(chk) {
            chk = false;
            int fst = 0;
            for(int i = 0; i < n; i++) {
                if(arr[i] != 0) {
                    fst = i;
                    break;
                }
            }
            int len = 1;
            for(int i = fst + 1; i < n; i++) {
                if(arr[i] != 0) {
                    if(arr[i] == arr[fst]) {
                        len++;
                    }
                    else {
                        if(len >= m) {
                            for(int j = fst; j < i; j++) {
                                arr[j] = 0;
                                chk = true;
                            }
                        }
                        fst = i;
                        len = 1;
                    }
                }
            }
            if(len >= m) {
                for(int j = fst; j < n; j++) {
                    arr[j] = 0;
                    chk = true;
                }
            }

        }
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] != 0)
                cnt++;
        }
        System.out.println(cnt);
        for(int i = 0; i < n; i++) {
            if(arr[i] != 0)
                System.out.println(arr[i]);
        }
    }
}
/*
4 2
1
2
2
1

3 2
1
1
1
* */