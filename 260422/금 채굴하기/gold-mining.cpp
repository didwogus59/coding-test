#include <iostream>
using namespace std;

int inRange(int x, int y, int range) {
    if (x >= 0 && y >= 0 && x < range && y < range)
        return true;
    return false;
}

int main() {

    int n, m;
    cin >> n >> m;

    int** arr = new int* [n];
    int cnt = 0;
    for (int i = 0; i < n; i++) {
        arr[i] = new int[n];
        for (int j = 0; j < n; j++) {
            cin >> arr[i][j];
            if (arr[i][j] == 1) {
                cnt++;
            }
        }
    }
    int max = 1;
    for (int i = 2; i < 10; i++) {
        if ((i * i) + ((i - 1) * (i - 1)) <= cnt * m) {
            max = i;
        }
    }

    int mx[4] = { 1,-1,0,0 };
    int my[4] = { 0,0,-1,1 };
    int ans = cnt > 0 ? 1 : 0;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {

            int** tmp = new int* [n];
            for (int a = 0; a < n; a++) {
                tmp[a] = new int[n];
            }

            for (int p = 0; p < n; p++) {
                for (int q = 0; q < n; q++) {
                    tmp[p][q] = 0;
                }
    
            }
   

            tmp[i][j] = 1;
            int gold = 0;
            if (arr[i][j] == 1) gold++;

            for (int r = 2; r <= max; r++) {
                for (int l = 1; l < r; l++) {
                    for (int x = 0; x < n; x++) {
                        for (int y = 0; y < n; y++) {
                            if (tmp[x][y] == l) {
                                for (int mv = 0; mv < 4; mv++) {
                                    
                                    if (inRange(x + mx[mv], y + my[mv], n)) {
                                        if (tmp[x + mx[mv]][y + my[mv]] == 0) {
                                            tmp[x + mx[mv]][y + my[mv]] = l + 1;
                                            gold += arr[x + mx[mv]][y + my[mv]];
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (gold > ans && gold * m >= (l * l) + ((l + 1) * (l + 1))) {
                        ans = gold;
                    }
                }
            }
        }

    }
    std::cout << ans;
    return 0;
}
