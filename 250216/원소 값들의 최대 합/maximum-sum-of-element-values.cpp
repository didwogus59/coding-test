#include <iostream>

using namespace std;

int n, m;
int arr[100];

int main() {
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    // Write your code here!
    int ans = 0;
    for(int i = 0; i < n; i++) {
        int sum = arr[i];
        int now = i;
        int bef = arr[i] - 1;
        for(int j = 1; j < m; j++) {
            
            // cout << now << " " << arr[now] << '\n';
            sum += arr[(now + bef) % n];
            now = (now + bef) % n;
            bef = arr[now] - 1;
        }
        // cout << sum <<'\n';
        ans = ans > sum ? ans : sum;
    }
    cout << ans;
    return 0;
}