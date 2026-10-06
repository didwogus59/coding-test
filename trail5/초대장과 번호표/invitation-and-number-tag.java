import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class Main {
    static int ans = 0;
    //    static int[] arr;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n + 1];
        arr[1] = 1;
        List<Set<Integer>> list = new ArrayList<>();
        HashMap<Integer, List<Integer>> key = new HashMap<>();
        for(int i = 0; i <= n; i++) {
            key.put(i, new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            Set<Integer> tmp = new TreeSet<>();
            int tmpSize = sc.nextInt();
            for (int p = 0; p < tmpSize; p++) {
                int now = sc.nextInt();
                tmp.add(now);
                key.get(now).add(i);
            }
            list.add(tmp);
        }
        Deque<Integer> deq = new ArrayDeque<>();
        Set<Integer> tic = new TreeSet<>();
        tic.add(1);
        deq.add(1);
        while(!deq.isEmpty()) {
            int now = deq.pop();
            for (int del : key.get(now)) {
                Set<Integer> tmp = list.get(del);
                tmp.remove(now);
                if(tmp.size() == 1) {
                    for(int left : tmp) {
                        if(!tic.contains(left)) {
                            deq.add(left);
                            arr[left] = 1;
                            tic.add(left);
                        }
                    }
                }
            }
        }
        ans = 0;
        for(int i = 0; i <= n; i++) {
            if(arr[i] == 1) {
                ans++;
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



