#include <iostream>

using namespace std;

int n;
int x1[100], x2[100];

int main() {
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> x1[i] >> x2[i];
    }
    int* cnt = new int[n];
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            if(i != j) {
                if(x1[i] < x1[j]) {
                    if(x2[i] > x2[j]) {
                        cnt[i] = 1;
                        cnt[j] = 1;
                    }
                }

            }

        }
    }
    int ans = 0;
    for(int i = 0; i < n; i++) {
        if(cnt[i] == 0)
            ans++;
    }
    cout << ans;
    return 0;
}