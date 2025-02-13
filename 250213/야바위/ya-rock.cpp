#include <iostream>

using namespace std;

int N;
int a[100], b[100], c[100];

int main() {
    cin >> N;

    for (int i = 0; i < N; i++) {
        cin >> a[i] >> b[i] >> c[i];
    }

    // Write your code here!
    
    int ans = 0;
    int max = 0;
    for(int i = 1; i < 4; i++) {
        int cnt = 0;
        int* coin = new int[4]{};
        coin[i] = 1;
        for(int j = 0; j < N; j++) {
            int tmp = coin[a[j]];
            coin[a[j]] = coin[b[j]];
            coin[b[j]] = tmp;
            cnt += coin[c[j]];
        }
        if(max < cnt) {
            ans = i;
            max = cnt;
        }
    }
    cout << ans;
    return 0;
}