#include <iostream>

using namespace std;

int N, K;
int num[100];

int main() {
    cin >> N >> K;

    for (int i = 0; i < N; i++) {
        cin >> num[i];
    }
    int ans = 0;
    for(int i = 0; i < N; i++) {
        for(int j = 1; j <= K; j++) {
            if(i - j >= 0) {
                if(num[i] == num[i - j]) {
                    ans = ans > num[i] ? ans : num[i];
                }
            }
            if(i + j < N) {
                if(num[i] == num[i + j]) {
                    ans = ans > num[i] ? ans : num[i];
                }
            }
        }
    }  
    cout << ans;

    return 0;
}