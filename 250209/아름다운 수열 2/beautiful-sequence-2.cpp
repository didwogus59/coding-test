#include <iostream>
#include <list>
#include <algorithm>
#include<string.h>
using namespace std;

int N, M;
int A[100], B[100];

int main() {
    cin >> N >> M;

    for (int i = 0; i < N; i++) cin >> A[i];

    for (int i = 0; i < M; i++) cin >> B[i];
    int m = M;
    int n = N;
    list<list<int>> lst;
    int* chk = new int[101];
    int ans = 0;
    for(int i = 0; i < m; i++) {
        chk[B[i]]++;
    }

    for(int i = 0; i < n - m + 1; i++) {
        int* tmp = new int[101];
        memcpy(tmp, chk, sizeof(int) * 101);
        int cnt = m;
 
        for(int j = 0; j < m; j++) {
            if(tmp[A[i + j]] > 0) {
                tmp[A[i + j]]--;
                cnt--;
            }
            else
                break;
        }
        if(cnt == 0) {
                ans++;
        }

    }
    cout << ans;
    // Write your code here!

    return 0;
}