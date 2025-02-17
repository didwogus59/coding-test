#include <iostream>
#include <string>

using namespace std;

int n;
string seat;
int dist(int* arr, int n) {
    int min = 200;
    int bef = -1;
    for(int i = 0; i < n; i++) {
        if(arr[i] == 1) {
            if(bef == - 1) {
                bef = i;
            }
            else {
                int dis = i - bef;
                bef = i;
                min = min < dis ? min : dis;
            }
        }
    }
    return min;
}
int main() {
    cin >> n;
    cin >> seat;
    int* arr = new int[n];

    for(int i = 0; i < n; i++) {
        if(seat[i] == '0')
            arr[i] = 0;
        else
            arr[i] = 1;
    }
    int ans = 0;
    for(int i = 0; i < n - 1; i++) {
        if(arr[i] == 0) {
            arr[i] = 1;
            for(int j = i + 1; j < n; j++) {
                if(arr[j] == 0) {
                    arr[j] = 1;
                    int dis = dist(arr, n);
                    ans = ans > dis ? ans : dis;
                    arr[j] = 0;
                }
            }
            arr[i] = 0;
        }
    }
    cout << ans;
    return 0;
}