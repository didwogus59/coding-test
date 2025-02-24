#include <iostream>
using namespace std;

int n;
int b[10000];

int main() {
    cin >> n;
    int sum = 0;
    for (int i = 0; i < n; i++) {
        cin >> b[i];
        sum += b[i];
    }
    int avg = sum / n;
    int cnt = 0;
    for(int i = 0; i < n; i++) {
        if(b[i] > avg) {
            cnt += b[i] - avg;
        }
    }
    cout << cnt;
    return 0;
}