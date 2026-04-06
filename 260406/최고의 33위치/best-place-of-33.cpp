#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;
    int** arr = new int*[n];
    for(int i = 0; i < n; i++) {
        arr[i] = new int[n];
        for(int j = 0; j < n; j++) {
            int tmp;
            cin >> tmp;
            arr[i][j] = tmp;
        }
    }
    int max = 0;
    for(int i = 0; i < n - 2; i++) {
        for(int j = 0; j < n - 2; j++) {
            int sum = 0;
            for(int p = 0; p < 3; p++) {
                for(int q = 0; q < 3; q++) {
                    sum += arr[i + p][j + q];
                }
            }
            max = max > sum ? max : sum;
        }
    }
    cout << max;
    return 0;
}