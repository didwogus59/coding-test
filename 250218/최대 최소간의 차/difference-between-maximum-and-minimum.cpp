#include <iostream>

using namespace std;

int n, k;
int arr[100];

int main() {
    cin >> n >> k;
    int max = 0;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
        max = max > arr[i] ? max : arr[i];
    }

    int ans = 10000000;
    for(int i = max; i >= 1; i--) {
        int sum = 0;
        for(int j = 0; j < n; j++) {
            if(arr[j] > i) {
                sum += arr[j] - i;
            }
            else {
                if(i - arr[j] > k) {
                    sum += i - arr[i] - k;
                }
            }
        }
        ans = ans < sum ? ans : sum;
    }
    cout << ans;
    return 0;
}