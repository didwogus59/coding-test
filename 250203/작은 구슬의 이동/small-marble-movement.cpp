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
    int dirX[] = {1,0,0,-1};
    int dirY[] = {0,-1,1,0};

    int dir;

    if(d == 'U') {
        dir = 3;
    }
    else if(d == 'D') {
        dir = 0;
    }
    else if(d == 'R') {
        dir = 2;
    }
    else {
        dir = 1;
    }
    
    for(int i = 0; i < t; i++) {
        x += dirX[dir];
        y += dirY[dir];
        if(!range(x,y)) {
            x -= dirX[dir];
            y -= dirY[dir];
            dir = 3 - dir;
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
