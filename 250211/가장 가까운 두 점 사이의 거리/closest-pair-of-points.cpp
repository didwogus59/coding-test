#include <iostream>

using namespace std;

int n;
int x[100], y[100];

int main() {
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> x[i] >> y[i];
    }
    int ans = 2 * 1000 * 10000 + 1;
    for(int i = 0; i < n - 1; i++) {
        for(int j = i + 1; j < n; j++) {
            int dx = x[i] - x[j];
            int dy = y[i] - y[j];
            int dis = dx*dx + dy*dy;
            ans = ans < dis ? ans : dis;
        }
    }
    cout << ans;
    return 0;
}