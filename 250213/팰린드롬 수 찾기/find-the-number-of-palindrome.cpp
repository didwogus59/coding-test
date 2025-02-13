#include <iostream>

using namespace std;

int X, Y;

int main() {
    cin >> X >> Y;
 int cnt = 0;
    for(int i = X; i <= Y; i++) {
        string str = to_string(i);
        int len = str.length();
       
        bool chk = true;
        for(int j = 0; j < len / 2; j++) {
            if(str[j] != str[len - 1 - j]) {
                chk = false;
                break;
            }
        }
        if(chk)
            cnt++;
    }
    cout << cnt;
    return 0;   
}