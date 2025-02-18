#include <iostream>

using namespace std;

int n;
int ad[1000];

int main() {
    cin >> n;

    for (int i = 0; i < n - 1; i++) {
        cin >> ad[i];
    }

    for(int i = 1; i <= n; i++) {
        int* arr = new int[n + 1]{};
        int* chk = new int[n + 1]{};
        bool ans = true;
        arr[0] = i;
        chk[i] = 1;
        for(int j = 1; j < n; j++) {
            int now = ad[j - 1] - arr[j - 1];
            if(chk[now] != 0) {
                ans = false;
                break;
            }
            else {
                chk[now] = 1;
                arr[j] = now;
            }
        }
        if(ans) {
            for(int i = 0; i < n; i++) {
                cout << arr[i] << " ";
            }
            return 0;
        }
    }
    return 0;
}
