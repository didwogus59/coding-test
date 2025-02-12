#include <iostream>

using namespace std;

int n;
int t[100][2];

int main() {
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> t[i][0] >> t[i][1];
    }
    // Write your code here!
    int ans = 0;
    for(int i = 0; i < n; i++) {
        
        int* work = new int[1001];
        for(int j = 0; j < n; j++) {
            if(j == i)
                continue;
            for(int p = t[j][0]; p < t[j][1]; p++) {
                work[p] = 1;
            }
        }
        int cnt = 0;
        for(int j = 0; j < 1001; j++) {
            if(work[j] != 0) {
                cnt++;
            }
        }
        ans = ans > cnt ? ans : cnt;
    }
    cout << ans;
    return 0;
}