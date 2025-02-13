#include <iostream>

using namespace std;

int n;
int a[100];

int main() {
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    int ans = 0;
    for(int i = 1; i <= 100; i++) {
        for(int p = 0; p < n - 1; p++) {
            for(int q = p + 1; q < n; q++) {
                if(i - a[p] == a[q] - i)
                    ans++;
            }
        }
    }
    // Write your code here!
    cout << ans;
    return 0;
}