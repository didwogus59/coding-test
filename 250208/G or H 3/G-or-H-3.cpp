#include <iostream>

using namespace std;

int N, K;
int x[100];
char c[100];

int main() {
    cin >> N >> K;

    for (int i = 0; i < N; i++) {
        cin >> x[i] >> c[i];
    }
    int n = N;
    int k = K;
    int* sc = new int[10001];
    for(int i = 0; i < n; i++) {
        sc[x[i] - 1] = c[i] == 'G' ? 1 : 2;
    }
    int sum = 0;
    for(int i = 0; i < k + 1; i++) {
        sum += sc[i];
    }
    int ans = sum;
    for(int i = k + 1; i < 10001; i++) {
        sum = sum + sc[i] - sc[i - k];
        ans = ans > sum ? ans : sum;
    }
    cout << ans;
    return 0;
}