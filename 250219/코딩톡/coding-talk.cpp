#include <iostream>

using namespace std;

int n, m, p;
char c[100];
int u[100];

int main() {
    cin >> n >> m >> p;

    for (int i = 0; i < m; i++) {
        cin >> c[i] >> u[i];
    }

    int user[27] = {};

    for(int i = p -1; i < m; i++) {
        user[int(c[i] - 'A')] = 1;
    }
    // for(int i = 0; i < n; i++) {
    //     if(user[i] == 1) {
    //         cnt++;
    //     }
    // }
    if(u[p-1] != 0) {
        for(int i = 0; i < n; i++) {
            if(user[i] == 0)
                cout << char(i + 'A') << " ";
        }
    }

    return 0;
}