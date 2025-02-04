#include <iostream>

using namespace std;

int n, m;
int arr[100][100];

int main() {
    cin >> n >> m;
    int dirX[] = {0,1,0,-1};
    int dirY[] = {1,0,-1,0};
    int dir = 0;
    int cnt = 1;
    int x = 0;
    int y = 0;
    while(arr[x][y] == 0) {
        arr[x][y] = cnt;
        cnt++;
        x += dirX[dir];
        y += dirY[dir];
        if(x >= 0 && x < n && y >= 0 && y < m) {
            if(arr[x][y] == 0)
                continue;
        }
        x -= dirX[dir];
        y -= dirY[dir];
        dir = (dir + 1) % 4;
        x += dirX[dir];
        y += dirY[dir];
    }
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cout << arr[i][j] << " ";
        }
        cout << endl;
    }
    return 0;
}