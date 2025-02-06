#include <iostream>

using namespace std;

int n;
int a[1003];

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    int ans = 1003 * 1004;
    for(int i = 0; i < n; i++) {
        int sum = 0;
        for(int j = 1; j < n; j++) {
            sum += (a[(i + j) % n] * j);
        }
        ans = ans > sum ? sum : ans;
    }
    cout << ans;
    return 0;
}