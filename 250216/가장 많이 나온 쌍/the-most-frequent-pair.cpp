#include <iostream>
using namespace std;

int main() {
    // Please write your code here.
    int n, m;
    cin >> n >> m;
    int** arr = new int*[m];
    for(int i = 0; i < m; i++) {
        arr[i] = new int[2];
        cin >> arr[i][0] >> arr[i][1];
    }
    int ans = 0;
    for(int i = 1; i <= n; i++) {
        for(int j = i; j <= n; j++) {
            int cnt = 0;
            for(int p = 0; p < m; p++) {
                if(arr[p][0] == i && arr[p][1] == j) {
                    cnt++;
                }
                else if(arr[p][1] == i && arr[p][0] == j) {
                    cnt++;
                }
            }
            ans = ans > cnt ? ans : cnt;
        }
        
    }
    cout << ans;
    return 0;
}