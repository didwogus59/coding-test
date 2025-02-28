#include<iostream>

using namespace std;

int main() {
    int n; 
    cin >> n;
    int arr[101];
    for(int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    for(int i = 1; i < n; i++) {
        int key = arr[i];
        int idx = 0;
        for(int j = i - 1; j >= 0; j--) {

            if(key > arr[j]) {
                idx = j + 1;
                break;
            }
            else {
                arr[j + 1] = arr[j];
            }
        }
        arr[idx] = key;

    }
    for(int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
    return 0;
}