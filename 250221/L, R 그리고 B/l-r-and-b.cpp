#include <iostream>

using namespace std;

char board[10][10];

int dis(int a, int b) {
    int dis = a > b ? a - b : b - a;
    return dis;
}
int main() {
    int xl, yl, xr,yr, xb, yb;
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            cin >> board[i][j];
            if(board[i][j] == 'L') {
                xl = i;
                yl = j;
            }
            if(board[i][j] == 'R') {
                xr = i;
                yr = j;
            }
            if(board[i][j] == 'B') {
                xb = i;
                yb = j;
            }
            
        }
    }
    if(xl == xb) {
        cout << dis(yl, yb) + 2;
    }
    else if(yl == yb) {
        cout << dis(xl, xb) + 2;
    }
    else {
        cout << dis(xl, xb) + dis(yl, yb) -1;
    }
    // Write your code here!

    return 0;
}