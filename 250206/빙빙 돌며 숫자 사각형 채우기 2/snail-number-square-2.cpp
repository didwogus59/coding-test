#include <iostream>

using namespace std;

int n, m;

int main() {
    cin >> n >> m;

    int** arr = new int*[n];
    for(int i = 0; i < n; i++) {
        arr[i] = new int[m];
    }

    int dirX[4] = {1, 0, -1, 0};
    int dirY[4] = {0, 1, 0, -1};
    int x = 0;
    int y = 0;
    int dir = 0;
    int cnt = 1;
    while(true) {
        arr[x][y] = cnt;
        cnt++;
        x += dirX[dir];
        y += dirY[dir];
        if(!(x >= 0 && x < n && y >= 0 && y < m)) {
            x -= dirX[dir];
            y -= dirY[dir];
            dir = (dir + 1) % 4;
            x += dirX[dir];
            y += dirY[dir];
        }
        else if(arr[x][y] != 0) {
            x -= dirX[dir];
            y -= dirY[dir];
            dir = (dir + 1) % 4;
            x += dirX[dir];
            y += dirY[dir];
        }
        if(cnt > n * m)
            break;
    }
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cout << arr[i][j] << " ";
        }
        cout << "\n";
    }
    return 0;
}