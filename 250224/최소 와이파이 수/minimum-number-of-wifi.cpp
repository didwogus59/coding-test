#include <iostream>

using namespace std;

int n, m;
int arr[100];

int main() {
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    int end = -1;
    int cnt = 0;
    for(int i = 0; i < n; i++) {
        if(arr[i] == 1) {
            if(end < i) {
                end = i + m * 2;
                cnt++;
            }
        }
    }
    cout << cnt;
    return 0;
}