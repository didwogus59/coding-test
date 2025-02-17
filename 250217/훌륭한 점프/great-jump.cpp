#include <iostream>

using namespace std;

int n, k;
int arr[100];
bool chk = false;
bool jump(int min) {
    int now = 0;
    while(now != n - 1) {
        int max = 0;
        for(int i = 1; i <= k && i + now < n; i++) {
            if(arr[now + i] <= min) {
                max = now + i;
            }
        }
        if(max == 0)
            return false;
        now = max;
    }
    return true;
}
int main() {
    cin >> n >> k;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    for(int i = 1; i <= 100; i++) {
        int max = i > arr[0] ? i : arr[0];
        if(jump(max)) {
            cout << max;
            return 0;
        }
        
    }
    // Write your code here!

    return 0;
}