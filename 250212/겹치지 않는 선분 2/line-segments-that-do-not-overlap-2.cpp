#include <iostream>

using namespace std;

int n;
int x1[100], x2[100];

int main() {
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> x1[i] >> x2[i];
    }
    int ans =n;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            if(i != j) {
                if(x1[i] < x1[j]) {
                    if(x2[i] > x2[j])
                        ans -= 2;
                }
            }
        }
    }
    cout << ans;
    return 0;
}