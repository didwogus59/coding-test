#include <iostream>
#include <algorithm>
using namespace std;

int n;
int arr[200000];

int main() {
    cin >> n;
    for (int i = 0; i < 2 * n; i++) {
        cin >> arr[i];
    }
    sort(arr, arr + (n * 2));
    int min = 1000000000;
    for(int i = 0; i < n; i++) {
        int diff = arr[i + n] - arr[i];
        min = min < diff ? min : diff;
    }
    cout << min;
    // Write your code here!

    return 0;
}