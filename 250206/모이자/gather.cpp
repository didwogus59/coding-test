#include <iostream>

using namespace std;

int n;
int A[100];

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> A[i];
    }
    int ans = 100 * 100 * 101;
    for(int i = 0; i < n; i++) {
        int sum = 0;
        for(int j = 0; j < n; j++) {
            int dis = i - j > 0? i - j : j - i;
            sum += dis * A[j];
        }
        ans = ans > sum ? sum : ans;
    }
    cout << ans;
    return 0;
}