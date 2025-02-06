#include <iostream>
#include <string>

using namespace std;

string A;

int main() {
    cin >> A;
    int ans = 0;
    // Write your code here!
    int len = A.length();
    for(int i1 = 0; i1 < len - 3; i1++) {
        if(A[i1] == '(' && A[i1 + 1] == '(') {
            for(int i2 = i1 + 2; i2 < len - 1; i2++) {
                if(A[i2] == ')' && A[i2 + 1] == ')')
                    ans++;
            }
        }
    }
    cout << ans;
    return 0;
}