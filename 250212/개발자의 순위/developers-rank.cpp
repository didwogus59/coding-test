#include <iostream>

using namespace std;

int k, n;
int bd[10][20];

int main() {
    cin >> k >> n;

    for (int i = 0; i < k; i++)
        for (int j = 0; j < n; j++) cin >> bd[i][j];
    int arr[10][20];
    for(int i = 0; i < k; i++) {
        for(int j = 0; j < n; j++) {
            arr[i][bd[i][j] - 1] = j;
        }
    }
    // for(int i = 0; i < k; i++) {
    //     for(int j = 0; j < n; j++) {
    //         cout << arr[i][j] << " ";
    //     }
    //     cout << '\n';
    // }//      2  3  4  1
    int cnt = 0;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            bool chk = true;
            for(int p = 0; p < k; p++) {
                
                if(arr[p][i] >= arr[p][j]) {
                    chk = false;
                    break;
                }
            }
            if(chk) {
                cnt++;
            }
        }
    }
    cout << cnt;

    return 0;
}