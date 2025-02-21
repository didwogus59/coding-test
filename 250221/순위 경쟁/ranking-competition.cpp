#include<iostream>

using namespace std;
string fst(int a, int b, int c) {
    string tmp = "";
    if(a >= b && a >= c)
        tmp += 'a';
    if(b >= a && b >= c)
        tmp += 'b';
    if(c >= a && c >= b)
        tmp += 'c';
    
    return tmp;
}
int main() {
    int n;
    cin >> n;
    int a = 0, b = 0, c = 0;
    int ba = 0, bb = 0, bc = 0;
    int cnt = 0;
    for(int i = 0; i < n; i++) {
        char tmp;
        int p;
        cin >> tmp >> p;
        if(tmp == 'A') {
            a += p;
        }
        else if(tmp == 'B') {
            b += p;
        }
        else {
            c += p;
        }
        if(fst(a,b,c) != fst(ba,bb,bc)) {
            cnt++;
        }
        ba = a;
        bb = b;
        bc = c;
        
    }
    cout << cnt;
}