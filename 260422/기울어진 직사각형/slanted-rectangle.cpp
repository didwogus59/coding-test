#include <iostream>
using namespace std;

bool inRange(int,int,int,int);
int cal(int,int,int,int,int,int,int**);
int main() {
    // Please write your code here.
    int w, h;
    cin >> h;
    w = h;
    int** arr = new int*[h];

    for(int i = 0; i < h; i++) {
        arr[i] = new int[w];
        for(int j = 0; j < w; j++) {
            cin >> arr[i][j];
        }
    }
    int ans = 0;
    for(int x = 0; x < h; x++) {
        for(int y = 0; y < w; y++) {
            for(int rx = 1; rx <= h; rx++) {
                for(int ry = 1; ry <= w; ry++) {
                    int sum = cal(x,y, rx, ry,h,w, arr);
                    if(ans < sum) {
                        ans = sum;
                    }
                }
            }
        }
    }
    cout << ans;
    return 0;
}

bool inRange(int x, int y, int h, int w) {
    if(x >= 0 && y >= 0 && x < h && y < w) 
        return true;
    return false;
}

int cal(int x, int y, int rx, int ry, int h, int w, int** arr) {
    int mx[4] = {1,1,-1,-1};
    int my[4] = {-1,1,1,-1};
    int sum = 0;
    for(int m = 0; m < 4; m++) {
        for(int i = 0; i < rx; i++) {
            x += mx[m];
            y += my[m];
            if(!inRange(x,y,h,w)) {
                return 0;
            }
            sum += arr[x][y];
        }
        m++;
        for(int i = 0; i < ry; i++) {
            x += mx[m];
            y += my[m];
            if(!inRange(x,y,h,w)) {
                return 0;
            }
            sum += arr[x][y];
        }
    }
    return sum;
}