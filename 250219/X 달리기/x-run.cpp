#include<iostream>

using namespace std;

int main() {
    int n;
    cin >> n;
    int ans = n*n;
    for(int i = 1; i < n; i++) {
        int cnt = 0;
        int spd = 1;
        int dis = 0;
        while(spd < i) {
            dis += spd;
            spd++;
            cnt++;
        }
        while(spd > 1) {
            dis += spd;
            spd--;
            cnt++;
        }
        dis++;
        cnt++;
        // cout << i << " " << dis << " " << cnt << '\n';
        if(dis == n) {
            ans = ans < cnt ? ans : cnt;
        }
        else if(dis < n) {
            cnt += n - dis;
            ans = ans < cnt ? ans : cnt;
        }
    }
    cout << ans;
    return 0;
}