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
                        int tmp = arr[p] - bef;
                        if(tmp < 0) {
                            tmp *= -1;
                        }
                        sum += tmp;
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