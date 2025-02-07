#include <iostream>
#include <string>

using namespace std;

int n;
string str;

int main() {
    cin >> n;
    cin >> str;
    int ans = 0;
    // Write your code here!
    int len = str.length();
    for(int i = 0; i < len - 2; i++) {
        if(str[i] == 'C') {
            for(int j = i + 1; j < len - 1; j++) {
                if(str[j] == 'O') {
                    for(int p = j + 1; p < len; p++) {
                        if(str[p] == 'W')
                            ans++;
                    }
                }
            }
        }
    }
    cout << ans;
    return 0;
}