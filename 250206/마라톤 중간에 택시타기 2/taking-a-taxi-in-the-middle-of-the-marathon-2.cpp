#include <iostream>

using namespace std;

int n;
int x[100];
int y[100];

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> x[i] >> y[i];
    }
    int ans = 101 * 4000;
    for(int i = 1; i < n - 1; i++) {
        int len = 0;
        int nx = x[0];
        int ny = y[0];
        for(int j = 1; j < n; j++) {
            if(i != j) {
                len += ((nx > x[j]) ? nx - x[j] : x[j] - nx) + ((ny > y[j]) ? ny - y[j] : y[j] - ny);
                nx = x[j];
                ny = y[j]; 
            }
        }
        ans = ans > len ? len : ans;
    }
    // Write your code here!
    cout << ans;
    return 0;
}