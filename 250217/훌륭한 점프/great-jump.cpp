#include <iostream>

using namespace std;

int n, k;
int arr[100];
bool chk = false;
void jump(int now, int min) {
    if(now == min) {
        chk = true;
    }
    else {
        int max = -1;
        for(int i = 1; i <= k && i + now < n; i++) {
            if(arr[now + i] <= min) {
                max = now + i;
            }
        }
        if(max != - 1)
            jump(max, min);
    }
}
int main() {
    cin >> n >> k;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    for(int i = 1; i <= 100; i++) {
        jump(0,i);
        if(chk) {
            cout << i;
            return 0;
        }
    }
    // Write your code here!

    return 0;
}