#include<iostream>

using namespace std;

int main() {
    int a, b, c;

    cin >> a >> b >> c;

    int disA = a > b ? a - b : b - a;
    int disC = b > c ? b - c : c - b;
    int dis = disA > disC ? disA : disC;

    cout << dis - 1;

    return 0;
    
}


// 1 5 10    5 6 10   6 7 10 7 8 10 8 9 10