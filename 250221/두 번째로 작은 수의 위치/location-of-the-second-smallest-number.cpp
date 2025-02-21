#include<iostream>

using namespace std;

int main() {
    int n;
    cin >> n;
    int arr[101];
    for(int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    int min1 = 200;
    int p1 = 0;
    
    for(int i = 0; i < n; i++) {
        if(arr[i] < min1) {
            min1 = arr[i];
            p1 = i;
        }
    }
    int min2 = 200;
    int p2 = -2;
    for(int i = 0; i < n; i++) {
        if(arr[i] != min1) {
            if(arr[i] < min2) {
                min2 = arr[i];
                p2 = i;
            }
            else if(arr[i] == min2) {
                cout << -1;
                return 0;
            }
        }
    }
    // cout << p1 << " " << min1 << '\n' << min2 << " ";
    cout << p2 + 1;
    return 0;
}