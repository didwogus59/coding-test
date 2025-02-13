#include <iostream>

using namespace std;

int A, B, C;

int main() {
    cin >> A >> B >> C;
    int n = C / A + 1;
    int m = C / B + 1;
    int ans = A;
    for(int i = 0; i <= n; i++) {
        for(int j = 0; j <= m; j++) {
            int now = A*i + B*j;
            if(now <= C) {
                ans = ans > now ? ans : now;
            }
        }
    }
    cout << ans;
    return 0;
}