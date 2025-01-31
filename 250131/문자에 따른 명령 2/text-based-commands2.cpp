#include <iostream>

using namespace std;

string dirs;

int main() {
    cin >> dirs;

    int x = 0;
    int y = 0;
    int now = 0;
    int dx[] = {1,0,-1,0};
    int dy[] = {0,1,0,-1};

    for(char c : dirs) {
        if(c == 'R') {
            now = (now + 1) % 4;
        }
        else if(c == 'L') {
            now = (now + 3) % 4;
        }
        else {
            x += dx[now];
            y += dy[now];
        }
    } 
    cout << y << " " << x << endl;
    return 0;
}