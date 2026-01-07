import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        heapSort(arr);
        for(int i : arr) {
            System.out.printf("%d ", i);
        }
    }
    
    static void heapSort(int[] arr) {
        int len = arr.length;
        for(int i = len / 2 + 1; i >= 0; i--) {
            heap(arr, i, len - 1);
        }
        while(len > 0) {
            int tmp = arr[len - 1];
            arr[len - 1] = arr[0];
            arr[0] = tmp;
            len--;
            heap(arr, 0, len - 1);
        }
    }

    static void heap(int[] arr, int n, int max) {
        int left = (n + 1) * 2;
        int right = (n + 1) * 2 - 1;
        if(max >= right) {
            left = left < max ? left : max;
            if(arr[n] < arr[left] || arr[n] < arr[right]) {
                if(arr[left] < arr[right]) {
                    int tmp = arr[n];
                    arr[n] = arr[right];
                    arr[right] = tmp;
                    heap(arr, right, max);
                }
                else {
                    int tmp = arr[n];
                    arr[n] = arr[left];
                    arr[left] = tmp;
                    heap(arr, left, max);    
                }
            }
        }
    }
}