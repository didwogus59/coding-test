#include <iostream>

using namespace std;

int n;
int x[20], y[20];

int main() {
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> x[i] >> y[i];
    }
    for(int i = 0; i <= 20; i++) {
        
        for(int j = 0; j <= 22; j++) {
            for(int p = 0; p <= 22; p++) {
                int* arr = new int[n]{};
                for(int q = 0; q < n; q++) {
                    if(i < 11) {
                        if(x[q] == i) {
                            arr[q] = 1;
                        }
                    }
                    if(i > 10) {
                        if(y[q] == i - 11) {
                            arr[q] = 1;
                        }
                    }
                    if(j < 11) {
                        if(x[q] == j) {
                            arr[q] = 1;
                        }
                    }
                    if(j > 10) {
                        if(y[q] == j - 11) {
                            arr[q] = 1;
                        }
                    }
                    if(p < 11) {
                        if(x[q] == p) {
                            arr[q] = 1;
                        }
                    }
                    if(p > 10) {
                        if(y[q] == p- 11) {
                            arr[q] = 1;
                        }
                    }
                }
                bool chk = true;
                for(int q = 0; q < n; q++) {
                    if(arr[q] == 0) {
                        chk = false;
                        break;
                    }
                }
                if(chk) {
                    cout << 1;
                    return 0;
                }
            }
        }
    }
    // Write your code here!
    cout << 0;
    return 0;
}