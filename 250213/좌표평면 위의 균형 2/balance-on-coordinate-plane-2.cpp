#include <iostream>

using namespace std;

int n;
int x[100], y[100];

int main() {
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> x[i] >> y[i];
    }
    int ans = 100000000;
    for(int i = 0; i < 104; i += 2) {
        for(int j = 0; j < 104; j += 2) {
            int* cnt = new int[4]{};
            for(int p = 0; p < n; p++) {
                if(x[p] > i) {
                    if(y[p] > j) {
                        cnt[0]++;
                    }
                    else {
                        cnt[1]++;
                    }
                }   
                else {
                    if(y[p] > j) {
                        cnt[2]++;
                    }
                    else {
                        cnt[3]++;
                    }
                }
            }
            int max = 0;
            for(int p = 0; p < 4; p++) {
                max = max > cnt[p] ? max : cnt[p];
            }
            ans = ans < max ? ans : max;
        }
    }
    cout << ans;
    return 0;
}