#include <iostream>

using namespace std;

int N;
char dir[100];
int dist[100];

int main() {
    cin >> N;

    for (int i = 0; i < N; i++) {
        cin >> dir[i] >> dist[i];
    }

    int x = 0;
    int y = 0;
    int check = -1;
    int time = 0;
    for(int i = 0; i < N; i++) {
        int bx = x;
        int by = y;
        if(dir[i] == 'N') {
            x += dist[i];
        }
        if(dir[i] == 'S') {
            x -= dist[i];
        }
        if(dir[i] == 'W') {
            y += dist[i];
        }
        if(dir[i] == 'E') {
            y -= dist[i];
        }
        if(x == 0 && y * by <= 0 && i > 0) {
            time = by > 0 ? time + by : time -by;
            time = bx > 0 ? time + bx : time -bx;
            check = 1;
            break;
        }
            
        if(y == 0 && x * bx <= 0 && i > 0) {
            time = bx > 0 ? time + bx : time -bx;
            time = by > 0 ? time + by : time -by;
            check = 1;
            break;

        }
        time += dist[i];
    }
    if(check == 1)
        cout << time;
    else
        cout << check;
    return 0;
}