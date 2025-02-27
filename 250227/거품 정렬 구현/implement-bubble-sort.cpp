#include <iostream>

using namespace std;

int n;
int arr[100];

int main() {
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    for(int i = 0; i < n; i++) {
        bool sorted = true;
        for(int j = 0; j < n - 1 - i; j++) {
            if(arr[j] > arr[j + 1]) {
                sorted = false;
                int tmp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = tmp;
            }
        }
        if(sorted)
            break;
    }
    // Please write your code here.
    for(int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
    return 0;
}
