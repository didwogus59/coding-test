#include <iostream>

using namespace std;

int N;
string command[10000];
int num[10000];

int main() {
    cin >> N;
    int now = 0;
    for (int i = 0; i < N; i++) {
        string tmp;
        cin >> tmp;
        if(tmp == "push_back") {
            int n;
            cin >> n;
            num[now] = n;
            now++;
        }
        else if(tmp == "get") {
            int n;
            cin >> n;
            cout << num[n-1]<< '\n';
        }
        else if(tmp == "size") {
            cout << now << '\n';
        }
        else {
            now--;
        }
    }

    // Please write your code here.

    return 0;
}
