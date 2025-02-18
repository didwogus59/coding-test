#include<iostream>
using namespace std;

int n, m;
int* arr;

int main() {
    cin >> n >> m;
    arr = new int[n];
    for(int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    int sum[101];
    sum[0] = arr[0];
    for(int i = 1; i < n; i++) {
        sum[i] = arr[i] + sum[i-1];
    }

    for(int i = sum[0]; i <= sum[n - 1]; i++) {
        int bef = 0;
        int cnt = 0;
        for(int j = 0; j < n; j++) {
            
            if(sum[j] - bef > i) {
                
                if(j == 0)
                    break;
                if(bef == sum[j - 1])
                    break;
                bef = sum[j - 1];
                j--;
                cnt++;
                if(cnt == m - 1)
                    break;
            }
            
        }
        if(sum[n - 1] - bef <= i) {
            if(cnt <= m - 1) {
                cout << i;
                return 0;
            }
        }
    }
}