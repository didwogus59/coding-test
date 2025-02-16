#include <iostream>
#include <string>

using namespace std;

int N;
string seat;

int main() {
    cin >> N;
    cin >> seat;
    int len = seat.length();
    int* arr = new int[len];
    for(int i = 0; i < len; i++) {
        if(seat[i] == '0') {
            arr[i] = 0;
        }
        else
            arr[i] = 1;
    }
    int ans = -1;
    for(int i = 0; i < len; i++) {
        if(arr[i] == 0) {
            arr[i] = 1;
            int dis = len + 1;
            for(int j = 1; j < len; j++) {
                if(i + j < len && arr[i + j] == 1) {
                    dis = dis < j ? dis : j;
                }
                if(i - j >= 0 && arr[i - j] == 1) {
                    dis = dis < j ? dis : j;
                }
            }
            if(dis != len + 1) {
                ans = ans > dis ? ans : dis;
                // cout << i << " " << dis << '\n';
            }
            arr[i] = 0;
        }
    }
    cout << ans;
    return 0;
}