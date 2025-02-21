#include<iostream>

using namespace std;

int main() {
    int n;
    cin >> n;
    int a = 0, b = 0, cnt = 0;
    int ba = 0, bb = 0;
    for(int i = 0; i < n; i++) {
        char w;
        int p;
        cin >> w >> p;
        if(w == 'A') {
            a += p;
        }
        else
            b += p;
        if(ba == bb) {
            if(p != 0) {
                cnt++;
            }
        }
        else if(ba > bb) {
            if(a <= b) {
                cnt++;
            }
        }
        else if(ba < bb) {
            if(a >= b) {
                cnt++;
            }
        }
        ba = a;
        bb = b;
    }
    cout << cnt;
    return 0;
}