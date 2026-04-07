#include <iostream>
using namespace std;

int main() {
    // Please write your code here.
    int n, m;
    cin >> n >> m;
    int** arr = new int*[n];
    for(int i = 0; i < n; i++) {
        arr[i] = new int[n];
        for(int j = 0; j < n; j++) {
            int tmp;
            cin >> tmp;
            arr[i][j] = tmp; 
        }
    }
    int sum = 0;
    for(int i = 0 ; i < n; i++) {
        int cntR = 1;
        int cntC = 1;
        int chkR = 0;
        int chkC = 0;
        for(int j = 1; j < n; j++) {
            if(arr[i][j] == arr[i][j - 1]) {
                cntR += 1;
            }
            else {
                cntR = 1;
            }
            if(arr[j][i] == arr[j - 1][i]) {
                cntC += 1;
            }
            else {
                cntC = 1;
            }

            if(cntR >= m) {
                chkR = 1;
            }
            if(cntC >= m) {
                chkC = 1;
            }
        }
        sum += (chkR + chkC);
    }
    cout << sum;
    return 0;
}