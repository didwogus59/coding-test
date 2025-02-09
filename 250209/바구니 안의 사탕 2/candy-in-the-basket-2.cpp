#include <iostream>

using namespace std;

int N, K;
int candy[100], pos[100];

int main() {
    cin >> N >> K;

    for (int i = 0; i < N; i++) {
        cin >> candy[i] >> pos[i];
    }
    int n = N;
    int ans = 0;
    int* arr = new int[401];
    for(int i = 0; i < n; i++) {
        arr[pos[i]] += candy[i];
    }

    int k = K;
    for(int i = k; i < 401 - k; i++) {
        int sum = arr[i];
        for(int j = 1; j <= k; j++) {
            sum += arr[i - j];
            sum += arr[i + j];
        }
        ans = ans > sum ? ans : sum;
    }
    cout << ans;
    return 0;
}