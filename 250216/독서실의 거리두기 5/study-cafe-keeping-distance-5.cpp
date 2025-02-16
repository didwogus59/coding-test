#include <iostream>
#include <string>

using namespace std;

int N;
string seat;

int main() {
    cin >> N;
    cin >> seat;
    int len = N;
    int* arr = new int[len]{};
    for(int i = 0; i < len; i++) {
        if(seat[i] == '0') {
            arr[i] = 0;
        }
        else
            arr[i] = 1;
    }
    int ans = 0;
    for(int i = 0; i < len; i++) {
        if(arr[i] == 0) {
            arr[i] = 1;
            int dis = len + 1;
            for(int p = 0; p < len; p++) {
                if(arr[p] == 1) {
                    for(int q = 0; q < len; q++) {
                        if(p != q) {
                            if(arr[q] == 1) {
                                if(p > q) {
                                    dis = dis < p - q ? dis  : p - q;
                                }
                                else
                                    dis = dis < q - p ? dis : q - p;
                            }
                        }
                    }
                }
            }
            // cout << i << " " << dis << '\n';
            ans = ans > dis ? ans : dis;
            arr[i] = 0;
        }
    }
    cout << ans;
    return 0;
}