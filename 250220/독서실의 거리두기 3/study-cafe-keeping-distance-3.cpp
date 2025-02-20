#include <iostream>
#include <string>

using namespace std;

int n;
string st;

int main() {
    cin >> n;
    cin >> st;
    int arr[1000]{};
    // Write your code here!
    for(int i = 0; i < n; i++) {
        if(st[i] == '0') {
            arr[i] = 0;
        }
        else
            arr[i] = 1;
    }
    int bef = 0;
    int max = 0;
    int max_pos = 0;
    for(int i = 1; i < n; i++) {
        if(arr[i] == 1) {
            if(i - bef > max) {
                // cout << bef << " " << i <<" " << max << " " << i - bef << '\n';
                max = i - bef;
                max_pos = (i + bef) / 2;
            }
            bef = i;
        }
    }
    arr[max_pos] = 1;
    // // cout << max_pos << '\n';
    // for(int i = 0; i < n; i++) {
    //     cout << arr[i] << " ";
    // }
    // cout << '\n';
    int min = 1001;
    bef = 0;
    for(int i = 1; i < n; i++) {
        if(arr[i] == 1) {
            if(i - bef < min) {
                min = i - bef;
            }
            bef = i;
        } 
    }
    cout << min;
    return 0;
}