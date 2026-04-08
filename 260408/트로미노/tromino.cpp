#include <iostream>
using namespace std;

int main() {
    // Please write your code here.
    int arr[201][201];
    int n, m;
    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cin >> arr[i][j];
        }
    }
    int max = 0;
    for(int i = 0; i < n - 1; i++) {
        for(int j = 0; j < m - 1; j++) {
            int num[4] = {arr[i][j], arr[i+1][j], arr[i][j+1], arr[i+1][j+1]};
            int tmp = num[0] + num[1] + num[2] + num[3];
            for(int p = 0; p < 4; p++) {
                if(max < tmp - num[p]) {
                    max = tmp - num[p];
                }
            }
        }
    }
    for(int i = 0; i < n - 2; i++) {
        for(int j = 0; j < m; j++) {
            if(max < arr[i][j] + arr[i+1][j] + arr[i+2][j])
                max = arr[i][j] + arr[i+1][j] + arr[i+2][j];
        }
    }

    
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m-2; j++) {
            if(max < arr[i][j] + arr[i][j+1] + arr[i][j+2])
                max =arr[i][j] + arr[i][j+1] + arr[i][j+2];
        }
    }
    cout << max;
    return 0;
}