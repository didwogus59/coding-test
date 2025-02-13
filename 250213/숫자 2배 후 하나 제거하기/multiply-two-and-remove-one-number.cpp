#include <iostream>

using namespace std;

int n;
int arr[100];

int main() {
    cin >> n;
    int ans = 100 * 100 * 100;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    for(int i = 0; i < n; i++) {
        int save = arr[i];
        arr[i] *= 2;
        for(int j = 0; j < n; j++) {
            int bef = -1; 
            int sum = 0;
            for(int p = 0; p < n; p++) {
                if(p != j) {
                    if(bef == -1) {
                        bef = arr[p];
                    }
                    else {
                        int diff = arr[p] - bef;
                        if(diff < 0) {
                            diff *= -1;
                        }
                        sum += diff;
                        bef = arr[p];
                    }
                }
            }
            ans = ans < sum ? ans : sum;
        }
        arr[i] = save;
    }
    cout << ans;
    // Write your code here!

    return 0;
}