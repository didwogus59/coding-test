#include <iostream>

using namespace std;

string a;

int main() {
    cin >> a;
    int len = a.length();
    for(int i = 1; i < len; i++) {
        if(a[i] == '0') {
            a[i] = '1';
            break;
        }
    }
    int num = 0;
    int digit = 1;
    for(int i = len - 1; i >= 0; i--) {
        if(a[i] == '1')
            num += digit;
        digit *= 2;
    }
    cout << num;
    return 0;
}