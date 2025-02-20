#include<iostream>
using namespace std;

int absDis(int x, int y) {
    return x > y ? x - y : y - x;
}
int main() {
    int a,b,x,y;
    cin >> a >> b >> x >> y;

    int min = absDis(x,y);

    int telA = absDis(x,a) + absDis(b,y);
    int telB = absDis(x,b) + absDis(a,y);
    min = min < telA ? min : telA;
    min = min < telB ? min : telB;
    cout << min;
    return 0;
}