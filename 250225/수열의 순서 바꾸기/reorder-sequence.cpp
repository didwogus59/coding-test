#include<iostream>

using namespace std;

int main() {
    int n;
    cin >> n;
    int* arr = new int[n];

    for(int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    int ans = 0;
    while(true) {
        int now = arr[0];
        bool chk = true;
        for(int i = 1; i < n; i++) {
            bool order = true;
            int bef = arr[i];
            for(int j = i + 1; j < n; j++) {
                if(bef < arr[j]) {
                    bef = arr[j];
                }
                else{
                    order = false;
                    break;
                }
            }
            if(order) {
                int bet = i - 1;
                for(int j = i; j < n; j++) {
                    if(arr[j] < now) {
                        bet = j;
                    }
                }
                for(int j = 1; j <= bet; j++) {
                    arr[j - 1] = arr[j];
                }
                arr[bet] = now;
                break;
            }
        }
        
        ans++;
        chk = true;
        int bef = arr[0];
        for(int i = 1; i < n; i++) {
            if(arr[i] < bef) {
                chk = false;
            } 
            bef = arr[i];
        }

        if(chk) {
            break;
        }
        if(ans > n*n)
            break;
    }
    cout << ans;
    delete[] arr;
    return 0;
}