#include <iostream>

using namespace std;

int n;
int a[100];
int b[100];

int main() {
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }

    for (int i = 0; i < n; i++) {
        cin >> b[i];
    }
    int sum = 0;
    for(int i = n - 1; i >= 0; i--) {
        if(a[i] != b[i]) {
            int diff = b[i] - a[i];
            for(int j = i - 1; j >= 0; j--) {
                // cout << sum << '\n';
                if(a[j] != 0) {
                    if(a[j] >= diff) {
                        sum += (i - j) * diff;
                        a[j] -= diff;
                        break;
                    }
                    else {
                        sum += (i - j) * (a[j]);
                        diff -= a[j];
                        a[j] = 0;
                    }
                }
                // cout << i - j << " " <<diff <<'\n';
            }
        } 
        // cout << i << " " << sum << '\n';
    }
    cout << sum;
    // Write your code here!

    return 0;
}
//4 1 5 3 0 0
//3
//