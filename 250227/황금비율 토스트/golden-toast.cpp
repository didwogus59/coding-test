#include <iostream>
#include <list>
#include <string>
using namespace std;

int n, m;
string s;

int main() {
    cin >> n >> m;
    cin >> s;
    list<char> lst;
    list<char>::iterator it;
    
    for(int i = 0; i < n; i++) {
        lst.push_back(s[i]);
    }
    it = lst.end();
    for (int i = 0; i < m; i++) {
        char cmd;
        cin >> cmd;
        if (cmd == 'D') {
            it = lst.erase(it);
        }
        if(cmd == 'L') {
            if(it != lst.begin()) {
                it--;
            }
        }
        if(cmd == 'R') {
            if(it != lst.end()) {
                it++;
            }
        }
        if(cmd == 'P') {
            char tmp;
            cin >> tmp;
            lst.insert(it,tmp);

        }
    }
    for(it = lst.begin(); it != lst.end(); it++) {
        cout << *it;
    }

    // Please write your code here.

    return 0;
}
