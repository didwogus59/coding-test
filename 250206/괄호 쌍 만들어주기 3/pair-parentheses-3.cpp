#include <iostream>
#include <string>

using namespace std;

string A;

int main() {
    cin >> A;
    int len = A.length();
    int ans = 0;
    for(int i = 0; i < len; i++) {
        if(A[i] == '(') {
            for(int j = i + 1; j < len; j++) {
                if(A[j] == ')')
                    ans++;
            }
        }
    }
    cout << ans;
    return 0;
}