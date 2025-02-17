#include<iostream>
#include<queue>
using namespace std;
int ans;
int n, k;
int* arr;
void jump(int max, int now) {
    if(now != n) {
        for(int i = now; i < n && i - now < k; i++) {
            if(arr[i] > max) {
                jump(arr[i], i + 1);
            }
            else {
                jump(max, i + 1);
            }
        }
    }
    else {
        ans = ans < max ? ans : max;
    }
}
int main() {
    cin >> n >> k;

    arr = new int[n];
    for(int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    ans = 200;
    jump(arr[0], 0);

    cout << ans;
    return 0;
}