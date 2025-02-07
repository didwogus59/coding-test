#include <iostream>

using namespace std;

int board[19][19];
bool range(int x, int y) {
    if(x >= 0 && x < 19 && y >= 0 && y < 19)
        return true;
    return false;
}
int dirX[4] = {1,0,1,-1};
int dirY[4] = {0,1,1,1};
int main() {
    for (int i = 0; i < 19; i++)
        for (int j = 0; j < 19; j++) cin >> board[i][j];

    for(int i = 0; i < 19; i++) {
        for(int j = 0; j < 19; j++) {
            if(board[i][j] != 0) {
                for(int p = 0; p < 4; p++) {
                    bool chk = true;
                    for(int q = 1; q < 5; q++) {
                        int x = i + dirX[p] * q;
                        int y = j + dirY[p] * q;
                        if(range(x, y)) {
                            if(board[x][y] != board[i][j])
                                chk = false;
                        }
                        else
                            chk = false;
                    }
                    if(chk) {
                        cout << board[i][j] << '\n' << i + dirX[p] * 2 + 1 << " " << j + dirY[p] * 2 + 1;
                        return 0;
                    }
                }
            }
        }
    }
    cout << 0;
    return 0;
}