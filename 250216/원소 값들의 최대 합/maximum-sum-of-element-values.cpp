#include <iostream>

using namespace std;

int n, m;
int arr[100];

int main() {
    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
        cin >> arr[i];
    }

    // Write your code here!
    int ans = 0;
    for(int i = 1; i <= n; i++) {
        int sum = arr[i];
        int bef = arr[i];
        for(int j = 1; j < m; j++) {
            
            sum += arr[bef];
            bef = arr[bef];
        }
        ans = ans > sum ? ans : sum;
    }
    cout << ans;
    return 0;
}