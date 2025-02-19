#include<iostream>
using namespace std;
int main() {
    int a, b , c, d;
    cin >> a >> b;
    cin >> c >> d;

    int sum = b - a + d - c;
    if(b <= c || a >= d) {
        cout << sum;
    }
    else {
        int fst = a < c ? a : c;
        int lst = b > d ? b : d;
        cout << lst - fst;
    }
    return 0;

}