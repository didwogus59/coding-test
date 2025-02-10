#include <iostream>

using namespace std;

int ab[6];

int main() {
    int sum = 0;
    for (int i = 0; i < 6; i++) {
        cin >> ab[i];
        sum += ab[i];
    }

    // Write your code here!
    int ans = sum;
    for(int i = 0; i < 4; i++) {
        for(int j = i + 1; j < 5; j++) {
            for(int p = j + 1; p < 6; p++) {
                int diff = sum - (ab[i] + ab[j] + ab[p]) * 2;
                if(diff < 0)
                    diff *= -1;
                ans = ans < diff ? ans : diff;
            }
        }
    }
    cout << ans;
    return 0;
}