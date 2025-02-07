#include <iostream>

using namespace std;

int n;
int arr[20];
bool no_carry(int a, int b, int c);
int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    int ans = -1;
    for(int i = 0; i < n - 2; i++) {
        for(int j = i + 1; j < n - 1; j++) {
            for(int p = j + 1; p < n; p++) {
                int sum = arr[i] + arr[j] + arr[p];
                if(no_carry(arr[i], arr[j], arr[p])) {
                    ans = sum > ans ? sum : ans;
                }
            } 
        }
    }
    cout << ans;
    // Write your code here!

    return 0;
}
bool no_carry(int a, int b, int c) {
    while(a + b + c > 0) {
        if(a % 10 + b % 10 + c % 10 >= 10)
            return false;
        a /= 10;
        b /= 10;
        c /= 10;
    }
    return true;
}