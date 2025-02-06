#include <iostream>
#include <string>

using namespace std;

int n, T;
string str;
int arr[100][100];

int main() {
    cin >> n >> T;
    cin >> str;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> arr[i][j];
        }
    }

    int dirX[4] = {-1,0,1,0};
    int dirY[4] = {0,1,0,-1};
    int x = n / 2;
    int y = n / 2;
    int dir = 0;
    int sum = arr[x][y];

    for(char d : str) {
        int nx = x + dirX[dir];
        int ny = y + dirY[dir];
        if(d == 'F') {
            if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
                x = nx;
                y = ny;
                sum += arr[x][y];
            }
        }
        else if(d == 'R') {
            dir = (dir + 1) % 4;
        }
        else {
            dir = (dir + 3) % 4;
        }
    }
    cout << sum;
    return 0;
}