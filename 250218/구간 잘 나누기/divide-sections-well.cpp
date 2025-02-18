#include<iostream>
using namespace std;

int n, m;
int* arr;
int ans = 101;
void div(int now, int cnt, int max) {
    if(now < n && cnt < m - 1) {
        int sum = 0;
        for(int i = now; i < n; i++) {
            sum += arr[i];
            if(sum >= ans)
                break;
            max = max > sum ? max : sum;
            div(i + 1, cnt + 1, max);
        }
    }
    else {
        int sum = 0;
        for(int i = now; i < n; i++) {
            sum += arr[i];
        }
        max = max > sum ? max : sum;
        ans = ans < max ? ans : max;
    }
}
int main() {
    cin >> n >> m;
    arr = new int[n];
    for(int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    div(0,0,0);
    cout << ans;
    return 0;
}