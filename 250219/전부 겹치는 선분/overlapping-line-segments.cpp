#include <iostream>

using namespace std;

int n;
int x1[100], x2[100];

int main() {
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> x1[i] >> x2[i];
    }
    for(int i = 1; i <= 100; i++) {
        bool chk = true;
        for(int j = 0; j < n; j++) {
            if(i < x1[j] || i > x2[j]) {
                chk = false;
            }
        }
        if(chk) {
            cout << "Yes";
            return 0;
        }
    }
    cout << "No";
    // Write your code here!

    return 0;
}