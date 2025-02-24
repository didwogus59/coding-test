#include<iostream>

using namespace std;

int main() {
    int n;
    cin >> n;
    int o = 0;
    int e = 0;
    for(int i = 0; i < n; i++) {
        int tmp;
        cin >> tmp;
        if(tmp % 2 == 0) {
            e++;
        }
        else
            o++;
    }
    if(e > o) {
        cout << o * 2 + 1;
        
    }
    else if(e == o) {
        cout << o * 2;
    }
    else {
        while(o > e) {
            o -= 2;
            e++;
        }
        if(e > o) {
        cout << o * 2 + 1;
        
        }
        else if(e == o) {
            cout << o * 2;
        }
    }
    return 0;
}