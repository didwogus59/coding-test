#include <iostream>

using namespace std;

int X, Y;

int main() {
    cin >> X >> Y;
    int ans = 0;
    for(int i = X; i < Y; i++) {
        int now = i;
        int sum = 0;
        while(now > 0) {
            sum += now % 10;
            now /= 10;
        }
        ans = ans > sum ? ans : sum;
    }
    cout << ans;
}