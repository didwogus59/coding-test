#include<iostream>

using namespace std;

int main() {
    int n;
    cin >> n;
    int ans = n*n;
    int down[1000];
    for(int i = 1; i < n; i++) {
        int cnt = 0;
        int spd = 1;
        int dis = 0;
        while(spd <= i) {
            dis += spd;
            down[spd + 1] = dis;
            spd++;
            cnt++;
        }
        spd--;
        while(spd > 1) {
            // cout << i << " " << dis << " " << spd << " " << down[spd] << '\n';
            if(dis + down[spd] + spd > n) {
                spd--;
            }
            dis += spd;
            cnt++;
        }
        if(dis < n) {
            cnt += n - dis;
            dis = n;
        }

        if(dis == n) {
            ans = ans < cnt ? ans : cnt;
        }
        else if(dis < n) {
            cnt += n - dis;
            ans = ans < cnt ? ans : cnt;
        }
    }
    cout << ans << '\n';

    return 0;
}