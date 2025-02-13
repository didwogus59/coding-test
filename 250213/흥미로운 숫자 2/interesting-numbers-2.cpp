#include <iostream>

using namespace std;

int X, Y;

int main() {
    cin >> X >> Y;

    // Write your code here!
    int cnt = 0;
    for(int i = X; i <= Y; i++) {
        int now = i / 10;
        int n1 = i % 10;
        int n2 = -1;
        int c1 = 0;
        int c2 = 0;
        bool chk = true;
        while(now > 0) {
            if(n1 == now % 10) {
                c1++;
            }
            else {
                if(n2 == -1) {
                    n2 = now % 10;
                }
                else if(n2 == now % 10) {
                    c2++;
                }
                else {
                    chk = false;
                    break;
                }
            }
            now /= 10;
        }
        if(chk) {
            if(c1 == 1 || c2 == 1) {
                cnt++;
            }
        }
    }
    cout << cnt;
    return 0;
}