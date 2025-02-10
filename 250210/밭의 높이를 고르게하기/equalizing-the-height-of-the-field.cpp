#include <iostream>

using namespace std;

int N, H, T;
int arr[100];

int main() {
    cin >> N >> H >> T;
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }
    int n = N;//n - t - 1 + t - 1
    int t = T;
    int h = H;
    int ans = 201 * 101;
    for(int i = 0; i <= n - t; i++) {
        int sum = 0;
        for(int j = 0; j < t; j++) {
            sum += arr[i + j] > h ? arr[i + j] - h : h - arr[i + j];
        }
        ans = ans < sum ? ans : sum;
    }
    cout << ans;
    return 0;
}