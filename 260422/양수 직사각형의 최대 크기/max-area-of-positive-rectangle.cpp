#include <iostream>
using namespace std;

int cal(int x1, int x2, int y1, int y2, int** arr) {
    for(int x = x1; x <= x2; x++) {
        for(int y = y1; y <= y2; y++) {
            if(arr[x][y] < 0)
                return 0;
        }
    }
    return (x2 - x1 + 1) * (y2 - y1 + 1);
}
int main() {
    // Please write your code here.
    int w,h;
    cin >> h >> w;

    int** arr = new int*[h];
    for(int i =  0; i < h; i++) {
        arr[i] = new int[i];
        for(int j = 0; j < w; j++) {
            cin >> arr[i][j];
        }
    }
    int ans = 0;
    for(int x1 = 0; x1 < h; x1++) {
        for(int x2 = x1; x2 < h; x2++) {
            for(int y1 = 0; y1 < w; y1++) {
                for(int y2 = y1; y2 < w; y2++) {
                    int tmp = cal(x1,x2,y1,y2,arr);
                    ans = ans > tmp ? ans : tmp;
                }
            }
        }
    }
    cout << ans;
    return 0;
}