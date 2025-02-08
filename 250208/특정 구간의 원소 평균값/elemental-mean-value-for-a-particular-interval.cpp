#include <iostream>

using namespace std;

int n;
int arr[100];

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    int ans = n;

    for(int i = 0; i < n - 1; i++) {
        for(int j = i + 1; j < n; j++) {
            int sum = 0;
            for(int p = i; p <= j; p++) {
                sum += arr[p];
            }
            int mean = sum / (j - i + 1);
            if(mean * (j - i + 1) == sum) {
                for(int p = i; p <= j; p++) {
                    if(mean == arr[p]) {
                        ans++;
                        break;
                    }
                }
            }
        }
    }
    cout << ans;
    return 0;
}