#include <iostream>

using namespace std;

int N;
int A[100];

int main() {
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> A[i];
    }
    int ans = 0;
    for(int i1 = 0; i1 < N; i1++) {
        for(int i2 = i1 + 1; i2 < N; i2++) {
            if(A[i1] < A[i2]) {
                for(int i3 = i2 + 1; i3 < N; i3++) {
                    if(A[i2] < A[i3])
                        ans++;
                }
            }
        }
    }
    cout << ans;
    return 0;
}