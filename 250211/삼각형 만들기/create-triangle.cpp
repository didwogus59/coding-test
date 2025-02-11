#include <iostream>

using namespace std;

int N;
int x[100];
int y[100];

int main() {
    cin >> N;

    for (int i = 0; i < N; i++) {
        cin >> x[i] >> y[i];
    }
    int n = N;
    int ans = 0;
    for(int i = 0; i < n - 2; i++) {
        for(int j = i + 1; j < n - 1; j++) {
            for(int p = j + 1; p < n; p++) {
                if(y[i] == y[j] || y[j] == y[p] || y[p] == y[i]) {
                    int size;
                    if(x[i] == x[j] || x[j] == x[p] || x[p] == x[i]) {
                        if(x[i] - x[j] == 0) {
                            size = (x[i] - x[p]) * (y[i] - y[j]);
                        } 
                        else if(x[j] - x[p] == 0) {
                            size = (x[j] - x[i]) * (y[j] - y[p]);
                        }
                        else {
                            size = (x[i] - x[j]) * (y[i] - y[p]);
                        }
                        if(size < 0)
                            size *= -1;
                        ans = ans > size ? ans : size;

                    }
                }
            }
        }
    }
    cout << ans;

    return 0;
}