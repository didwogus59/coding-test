#include <iostream>
#include <string>

using namespace std;

string inp[3];

int main() {
    for (int i = 0; i < 3; i++) cin >> inp[i];
    int** bd = new int*[3];
    for(int i = 0; i < 3; i++) {
        bd[i] = new int[3];
        for(int j = 0; j < 3; j++) {
           bd[i][j] = inp[i][j] - '0';
        }
    }
    int ans = 0;
    for(int i = 1; i < 9; i++) {
        for(int j = i + 1; j < 10; j++) {
            int cnt = 0;
            for(int p = 0; p < 3; p++) {
                bool chk = true;
                int sum = 0;
                for(int q = 0; q < 3; q++) {
                    sum += bd[p][q];
                    if(bd[p][q] != i && bd[p][q] != j) {
                        chk = false;
                    }
                }
                if(chk) {
                    if(sum != 3 * i && sum != 3 * j)
                        cnt++;
                }
                chk = true;
                sum = 0;
                for(int q = 0; q < 3; q++) {
                    sum += bd[q][p];
                    if(bd[q][p] != i && bd[q][p] != j) {
                        chk = false;
                    }
                }
                if(chk) {
                    if(sum != 3 * i && sum != 3 * j)
                        cnt++;
                }
            }
            if(bd[1][1] == i || bd[1][1] == j) {
                if(bd[0][0] == i || bd[0][0] == j) {
                    if(bd[2][2] == i || bd[2][2] == j) {
                        int sum = bd[0][0] + bd[1][1] + bd[2][2];
                        if(sum != i * 3 && sum != j * 3)
                            cnt++;
                    }
                }
                if(bd[0][2] == i || bd[0][2] == j) {
                    if(bd[2][0] == i || bd[2][0] == j) {
                        int sum = bd[0][2] + bd[1][1] + bd[2][0];
                        if(sum != i * 3 && sum != j * 3)
                            cnt++;
                    }
                }
            }
            // cout << i << " " << j << "  " << cnt << '\n';
            if(cnt >= 1) {
                // cout << i << " " << j << '\n';
                ans++;
            }
        }
    }
    cout << ans;
    return 0;
}