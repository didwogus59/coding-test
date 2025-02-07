#include <iostream>

using namespace std;

int N, S;
int arr[100];

int main() {
    cin >> N >> S;
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }

    int n = N;
    int sum = 0;
    int s = S;
    int ans = sum > s ? sum - s : s - sum; 
    for(int i = 0; i < n; i++) sum += arr[i];

    for(int i = 0; i < n - 1; i++) {
        for(int j = i + 1; j < n; j++) {
            int now = sum - arr[i] - arr[j];
            int diff = now > s ? now - s : s - now;
            ans = ans < diff ? ans : diff;
        }
    }
    cout << ans;
    return 0;
}