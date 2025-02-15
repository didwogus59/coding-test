#include <iostream>
#include <string>
#include <set>
using namespace std;

int N;
string str;

int main() {
    cin >> N;
    cin >> str;
    set<string> s;
    int len = str.length();
    int ans = 0;
    for(int i = 0; i < str.length(); i++) {
        string tmp = "";
        for(int j = i; j < len; j++) {
            tmp += str[j];
            if(s.find(tmp) == s.end()) {
                s.insert(tmp);
            }
            else {
                ans = ans > tmp.length() ? ans : tmp.length();
            }
        }
    }
    // Write your code here!
    cout << ans + 1;
    return 0;
}