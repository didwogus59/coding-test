#include <iostream>

using namespace std;

int n;
char grid[1000][1000];
int k;

int main() {
    cin >> n;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> grid[i][j];
        }
    }

    cin >> k;
    int dirX[2][4] = {{0,1,0,-1},{0,-1,0,1}};
    int dirY[2][4] = {{-1,0,1,0},{1,0,-1,0}};
    int dir = (k - 1) / n;
    int x = 0;
    int y = 0;
    if(dir == 0) {
        x = 0;
        y = k -1;
    }
    if(dir == 1) {
        x = k - n - 1;
        y = n - 1;
    }
    if(dir == 2) {
        x = n - 1;
        y = 3 * n - k;
    }
    if(dir == 3) {
        x = 4 * n - k;
        y = 0;
    }
    int cnt = 0;
    while(true) {
        if(x >= 0 && x < n && y >= 0 && y < n) {
            cnt++;
            int glass = grid[x][y] == '/' ? 0 : 1;
            x += dirX[glass][dir];
            y += dirY[glass][dir];
            if(dirY[glass][dir] == 1) {
                dir = 3;
            }
            else if(dirY[glass][dir] == -1) {
                dir = 1;
            }
            else if(dirX[glass][dir] == 1) {
                dir = 0;
            }
            else if(dirX[glass][dir] == -1) {
                dir = 2;
            }
        }
        else {
            break;
        }
    }
    cout << cnt;
    return 0;
}