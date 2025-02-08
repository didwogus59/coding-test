#include <iostream>

using namespace std;

int n, k;
int arr[100];

int main() {
    cin >> n >> k;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    int sum = 0;
    for(   int i = 0; i < k; i++) {
        sum += arr[i];
    }
    int ans = sum;

    for(int i = k; i < n; i++) {
        sum= sum + arr[i] - arr[i - k];
        ans = ans > sum ? ans : sum;
    }
    cout << ans;
    return 0;
}