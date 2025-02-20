#include <iostream>
#include <algorithm>
using namespace std;

int p[3];

int main() {
    for (int i = 0; i < 3; i++) cin >> p[i];

    sort(p, p + 3);
    if(p[0] + 1 == p[1] && p[1] + 1 == p[2]) {
        cout << 0;
    }
    else if(p[0] + 2 == p[1] || p[1] + 2 == p[2]) {
        cout << 1;
    }
    else  
        cout << 2;
    return 0;
}