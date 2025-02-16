#include <iostream>

using namespace std;

int n;
int a[10], b[10];

int main() {
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> a[i] >> b[i];
    }

    for(int i = 1; i <= 10; i++) {
        int now = i;
        bool chk = true;
        for(int j = 0; j < n; j++) {
            now *= 2;
            if(now < a[j] || now > b[j] ) {
                chk = false;
            }
        }
        if(chk) {
            cout << i;
            return 0;
        }
    }

    return 0;
}