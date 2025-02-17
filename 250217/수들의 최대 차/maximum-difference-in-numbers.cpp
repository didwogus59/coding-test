#include <iostream>

using namespace std;

int n, k;
int arr[1000];

int main() {
    cin >> n >> k;

    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    // Write your code here!
    int ans = 0;
    for(int i = 0; i < n; i++) {
        int cnt = 0;
        for(int j = 0; j < n; j++) {
            if(arr[i] <= arr[j]) {
                if(arr[j] - arr[i] <= k) {
                    cnt++;
                }
            }
        }
        ans = ans > cnt ? ans : cnt;
    }
    cout << ans;
    return 0;
}