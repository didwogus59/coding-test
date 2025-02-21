#include <iostream>
#include <algorithm>
using namespace std;

int n;
int arr[100000];

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    int p[3];
    int m[3];
    
    sort(arr, arr + n);
    int max = arr[n - 1] * arr[n - 2] * arr[n - 3];
    int m2p1 = arr[0] * arr[1] * arr[n - 1];
    max = max > m2p1 ? max : m2p1;

    cout << max;
    return 0;
}

//가장 큰 양수 3개의 곱 or 가장 작은 음수 2개의 곱 과 가장 큰 양수의 곱
//만약 음수들만 + 0이면 그냥 0
//