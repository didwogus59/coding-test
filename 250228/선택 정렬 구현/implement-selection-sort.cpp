#include <iostream>
using namespace std;

int main() {
    // Please write your code here.
    int n;
    cin >> n;
    int arr[101];
    for(int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    for(int i = 0; i < n; i++) {
        int min = i;
        for(int j = i + 1; j < n; j++) {
            if(arr[min] > arr[j]) {
                min = j;
            }
        }
        int tmp = arr[min];
        arr[min] = arr[i];
        arr[i] = tmp;
    }
    for(int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
    return 0;
}