#include <iostream>
#include <string>

using namespace std;

int N, M;
string arr[50];

int main() {
    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }
    int n = N;
    int m = M;
    int ans = 0;
    int dirX[8] = {0,0,1,-1,-1,-1,1,1};
    int dirY[8] = {1,-1,0,0,1,-1,1,-1};
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {  
            if(arr[i][j] == 'L') {  
                for(int p = 0; p < 8; p++) {
                    bool chk = true;
                    for(int q = 1; q < 3; q++) {
                        int x = i + dirX[p] * q;
                        int y = j + dirY[p] * q;
                        if(x >= 0 && x < n && y >= 0 && y < m) {
                            if(arr[x][y] != 'E') {
                                chk = false;
                                break;
                            }
                        }
                        else {
                            chk = false;
                            break;
                        }
                    }
                    if(chk) {
                        ans++;
                    }
                }
            }
        }
    }
    cout << ans;
    return 0;
}