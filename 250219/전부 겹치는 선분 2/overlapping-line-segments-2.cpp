#include <iostream>

using namespace std;

int n;
int x1[100], x2[100];

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> x1[i] >> x2[i];
    }
    for(int i = 1; i <= 4; i++) {
        for(int j = 0; j < n; j++) {
            bool chk = true;
            for(int p = 0; p < n; p++) {
                if(p != j) {
                    if(x2[p] < i || x1[p] > i) {
                        // cout << i << " " << x1[p] << " " << x2[p] << '\n';
                        chk = false;
                        break;
                    } 
                }
            }
            if(chk) {
                cout << "Yes";
                return 0;
            }
        }
    }
    cout << "No";
    // Write your code here!

    return 0;
}