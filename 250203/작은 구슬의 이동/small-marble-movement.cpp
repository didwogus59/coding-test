#include <iostream>

using namespace std;

int n, t;
int r, c;
char d;
bool range(int, int);
int main() {
    cin >> n >> t;
    cin >> r >> c >> d;
    int x = r;
    int y = c;
    int dirX[] = {-1,0,0,1};
    int dirY[] = {0,-1,1,0};

    int dx,dy;

    if(d == 'U') {
        dx = 4;
        dy = 4;
    }
    else if(d == 'D') {
        dx = 0;
        dy = 0;
    }
    else if(d == 'R') {
        dx = 2;
        dy = 2;
    }
    else {
        dx = 1;
        dy = 1;
    }
    
    for(int i = 0; i < t; i++) {
        x += dirX[dx];
        y += dirY[dy];
        if(!range(x,y)) {
            x -= dirX[dx];
            y -= dirY[dy];
            dx = 3 - dx;
            dy = 3 - dy;
        }
    }
    cout << x << " " << y;
    return 0;
}

bool range(int x, int y) {
    if(x >= 1 && y >= 1 && x <= n && y <= n)
        return true;
    return false;
}