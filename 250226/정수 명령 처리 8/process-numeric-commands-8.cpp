#include <iostream>
#include <string>
#include <list>
using namespace std;

int N;

list<int> lst;
int main() {
    cin >> N;

    for (int i = 0; i < N; i++) {
        int n;
        string cmd;
        cin >> cmd;
        if (cmd == "push_front") {
            cin >> n;
            lst.push_front(n);
        }
        else if(cmd == "push_back") {
            cin >> n;
            lst.push_back(n);
        }
        else if(cmd == "pop_front") {
            n = lst.front();
            lst.pop_front();
            cout << n << '\n';
        }
        else if(cmd == "pop_back") {
            n = lst.back();
            lst.pop_back();
            cout << n << '\n';
        }
        else if(cmd == "back") {
            n = lst.back();
            cout << n << '\n';
        }
        else if(cmd == "size") {
            n = lst.size();
            cout << n << '\n';
        }
        else if(cmd == "front") {
            n = lst.front();
            cout << n << '\n';
        }
        else {
            if(lst.empty()) {
                cout << "1\n";
            }
            else
                cout << "0\n";
        }
    }

    // Please write your code here.

    return 0;
}
