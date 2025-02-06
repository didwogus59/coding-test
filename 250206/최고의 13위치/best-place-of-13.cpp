#include <iostream>

using namespace std;

int N;
int grid[20][20];

int main() {
    cin >> N;
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++) cin >> grid[i][j];

    int ans = 0;
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < N - 2; j++) {
            int tmp = 0;
            for(int p = 0; p < 3; p++) {
                tmp += grid[i][j + p]; 
            }
            ans = ans < tmp ? tmp : ans;
        }
    }
    cout << ans;
    return 0;
}