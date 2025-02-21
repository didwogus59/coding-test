#include <iostream>

using namespace std;

char board[10][10];

int dis(int a, int b) {
    int dis = a > b ? a - b : b - a;
    return dis;
}

bool bet(int a, int b, int c) {
    if(a > b) {
        int tmp = a;
        a = b;
        b = tmp;
    }
    if(a < c && c < b)
        return true;
    return false;
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
    int d;
    if(xl == xb) {
        d = dis(yl, yb);
        if(xr == xl && bet(yl,yb,yr)) {
            d += 1;
            // cout << "1\n";
        }
       
    }
    else if(yl == yb) {
        d = dis(xl, xb);
        if(yr == yl && bet(xl, xb, xr)) {
            d += 1;
            // cout << "2\n";
        }
    }
    else {
        d = dis(xl, xb) + dis(yl, yb) -1;
    }
     cout << d;
    // Write your code here!

    return 0;
}