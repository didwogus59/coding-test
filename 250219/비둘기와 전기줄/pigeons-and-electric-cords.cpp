#include <iostream>

using namespace std;

int n;
int p[100];
int pos[100];

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> p[i] >> pos[i];
    }

    // Write your code here!
    int r[11] = {};
    int l[11] = {};
    int cnt = 0;
    for(int i = 0; i < n; i++) {
        if(pos[i] == 0) {
            if(l[p[i]] != 0) {
                l[p[i]] = 0;
                cnt++;
            }
            r[p[i]] = 1;
        }
        else {
            if(r[p[i]] != 0) {
                r[p[i]] = 0;
                cnt++;
            }
            l[p[i]] = 1;
        }
    }    
    cout << cnt;
    return 0;
}