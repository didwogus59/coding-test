#include<iostream>

using namespace std;
int game(int x, int y) {
    if(x == 1 && y == 2) {
        return 1;
    }
    if(x == 2 && y == 3) {
        return 1;
    }
    if(x == 3 && y == 1) {
        return 1;
    }
    return 0;
}
int main() {

    int n;
    cin >> n;
    int g[101][2];
    for(int i = 0; i < n; i++) {
        cin >> g[i][0] >> g[i][1];
    }

    int rsp[6][3] = {{1,2,3},{1,3,2},{2,1,3},{2,3,1},{3,1,2},{3,2,1}};
    int ans = 0;
    for(int i = 0; i < 6; i++) {
        int cnt = 0;
        for(int j = 0; j < n; j++) {
            cnt += game(rsp[i][g[j][0]],rsp[i][g[j][1]]);
        }
        ans = ans > cnt ? ans : cnt;
    }
    cout << ans;
    return 0;
}