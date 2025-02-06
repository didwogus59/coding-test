#include <iostream>
#include <queue>
using namespace std;

int R, C;
int arr[15][15];
struct pt {
    int x;
    int y;
    int cnt;
    pt(int x, int y, int cnt) {
        this->x = x;
        this->y = y;
        this->cnt = cnt;
    } 
};
int main() {
    cin >> R >> C;
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            char tmp;
            cin >> tmp;
            arr[i][j] = tmp == 'W' ? 1 : 0;
        }
    }
    int ans = 0;
    queue<pt> que;
    que.push(pt(0,0,0));
    while(!que.empty()) {
        int x = que.front().x;
        int y = que.front().y;
        int cnt = que.front().cnt;
        
        // cout << x << " " << y << " " << cnt << endl;
        if(x == R - 1 && y == C - 1 && cnt == 3) {
            ans++;
        }
        que.pop();
        if(cnt > 2)
            continue;
        for(int i = x + 1; i < R; i++) {
            for(int j = y + 1; j < C; j++) {
                if(arr[x][y] != arr[i][j]) {
                    que.push(pt(i,j,cnt+1));
                }
            }
        }
    }
    cout << ans;
    return 0;
}