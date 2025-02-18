#include <iostream>
#include <algorithm>
using namespace std;

int N, L;
int a[100];

int main() {
    cin >> N >> L;

    for (int i = 0; i < N; i++) {
        cin >> a[i];
    }
    int n = N;
    sort(a, a+ n);
    for(int i = 1; i < 300; i++) {
        int plus = L;
        int cnt = 0;
        for(int j = n - 1; j >= 0; j--) {
            if(a[j] < i) {
                plus -= i - a[j];
                if(plus >= 0) {
                    cnt++;
                }
                else
                    break;
            }
            else {
                cnt++;
            }
        }
        if(cnt < i) {
            cout << i - 1;
            return 0;
        }
    }
    return 0;
}