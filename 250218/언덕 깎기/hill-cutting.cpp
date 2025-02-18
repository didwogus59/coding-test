#include<iostream>
using namespace std;

int main() {
    int n;
    cin >> n;
    int* arr = new int[n];
    int min = 10001;
    int max = 0;
    for(int i = 0; i < n; i++) {
        cin >> arr[i];
        min = min < arr[i] ? min : arr[i];
        max = max > arr[i] ? max : arr[i];
    }
    int ans = 100*100*1000;
    for(int i = min; i <= max; i++) {
        int sum = 0;
        for(int j = 0; j < n; j++) {
            if(arr[j] > i) {
                int diff = arr[j] - i;
                sum += diff * diff;
            }
            else {
                int diff = i - arr[j]>= 17 ? i - arr[j] - 17 : 0;
                sum += diff * diff;    
            }
        }
        // cout << i << " " << sum << '\n';
        ans = ans < sum ? ans : sum;
    }
    cout << ans;
    return 0;
}