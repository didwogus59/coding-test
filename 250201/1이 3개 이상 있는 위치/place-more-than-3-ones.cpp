#include <iostream>

using namespace std;

int n;
int grid[100][100];

int main() {
    cin >> n;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> grid[i][j];
        }
    }

    // Write your code here!

    int dirX[] = {0,0,1,-1};
    int dirY[] = {1,-1,0,0};
    int ans = 0;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            int cnt = 0;
            for(int p = 0; p < 4; p++) {
                int x = i + dirX[p];
                int y = j + dirY[p]; 
                if(x >= 0 && x < n && y >= 0 && y < n) {
                    if(grid[x][y] == 1) 
                        cnt++;
                }
            }
            if(cnt > 2)
                ans++;
        }
    }
    cout << ans;
    return 0;
}