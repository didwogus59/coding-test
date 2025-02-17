#include<iostream>
#include<algorithm>
using namespace std;
int main() {
    int n = 15;
    int* arr = new int[n];
    for(int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    sort(arr, arr + n);

    int a = arr[0];
    int b = arr[1];
    int c = arr[2];
    if(arr[2] == a + b) {
        c = arr[3];
    }
    int d = arr[14] - a - b - c;
    cout << a << " " << b << " " << c << " " << d;
}