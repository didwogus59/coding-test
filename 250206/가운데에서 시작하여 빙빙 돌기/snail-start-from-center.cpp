#include <iostream>

using namespace std;

int n;
int grid[100][100];

int main() {
    cin >> n;

    int x = n - 1;
    int y = n - 1;

    int** arr = new int*[n];
    for(int i = 0; i < n; i++) {
        arr[i] = new int[n];
    }

    int dirX[4] = {0,-1,0,1};
    int dirY[4] = {-1,0,1,0};
    int dir = 0;
    int cnt = n * n;
    while(true) {
        arr[x][y] = cnt;
        int nx = x + dirX[dir];
        int ny = y + dirY[dir];
        if(nx < 0 || ny < 0 || nx >= n || ny >= n) {
            dir = (dir + 1) % 4;
        }
        else if(arr[nx][ny]) {
            dir = (dir + 1) % 4;
        }
        x += dirX[dir];
        y += dirY[dir];
        if(arr[x][y] != 0)
            break;
        if(x < 0 || y < 0 || x >= n || y >= n)
            break;
        cnt--;
    }
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            cout << arr[i][j] << " ";
        }
        cout <<'\n';
    }

    return 0;
}
