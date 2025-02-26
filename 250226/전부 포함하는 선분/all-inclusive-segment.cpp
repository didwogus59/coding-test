#include<iostream>

using namespace std;

int main() {

    int n;
    cin >> n;
    int arr[101][2];

    for(int i = 0; i < n; i++) {
        cin >> arr[i][0] >> arr[i][1];
    }
    int ans = 100000000;
    for(int i = 0;  i< n; i++) {
        int min = 100000;
        int max = -100000;
        for(int j = 0; j < n; j++) {
            if(i != j) {
                min = min < arr[j][0] ? min : arr[j][0];
                max = max > arr[j][1] ? max : arr[j][1];
            } 
        }
        int dis = max - min;
        ans = ans < dis ? ans : dis;
    }
    cout << ans;
}