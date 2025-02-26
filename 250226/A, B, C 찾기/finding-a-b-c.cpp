#include <iostream>
#include <algorithm>
using namespace std;

int arr[7];

int main() {
    for (int i = 0; i < 7; i++) {
        cin >> arr[i];
    }
    sort(arr, arr + 7);
    // Write your code here!
    int a = arr[0];
    int b = arr[1];
    int c = arr[6] - b - a;
    cout << a << " " << b << " " << c;
    return 0;
}