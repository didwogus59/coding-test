#include <iostream>

using namespace std;

int n;
int h[100];

int main() {
    cin >> n;
    int max = 0;
    for (int i = 0; i < n; i++) {
        cin >> h[i];
        max = max > h[i] ? max : h[i];
    }
    int ans = 0;
    for(int i = 0; i <= max; i++) {
        int cnt = 0;
        int chk = 1;
        for(int j = 0; j < n; j++) {
            if(h[j] <= i) {
                chk = 1;
            }
            if(h[j] > i) {
                cnt += chk;
                chk = 0;
            }
        }
        // cout << i << " " << cnt << '\n';
        ans = ans > cnt ? ans : cnt;
    }
    // Write your code here!
    cout << ans;
    return 0;
}