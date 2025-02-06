#include <iostream>

using namespace std;

int n, m;

int main() {
    cin >> n >> m;

    int** arr = new int*[n];
    for(int i = 0; i < n; i++) {
        arr[i] = new int[m];
    }

    int dirX[4] = {0,1,0,-1};
    int dirY[4] = {1,0,-1,0};

    int dir = 0;
    int x = 0;
    int y = 0;
    int cnt = 1;
    while(true) {
        arr[x][y] = cnt;
        int nx = x + dirX[dir];
        int ny = y + dirY[dir];
        if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
            dir = (dir + 1) % 4;
        }
        else { 
            if(arr[nx][ny] != 0)
                dir = (dir + 1) % 4;
        }
        x += dirX[dir];
        y += dirY[dir];
        if(arr[x][y] != 0) {
            break;
        }
        cnt++;
    }
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cout << (char)((arr[i][j] - 1) % 26 + 'A') << " ";
        }
        cout << '\n';
    }
    return 0;
}
