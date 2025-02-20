#include<iostream>
using namespace std;

int absDis(int x, int y) {
    return x > y ? x - y : y - x;
}
int main() {
    int a,b,x,y;
    cin >> a >> b >> x >> y;

    int min = absDis(a,b);

    int telA = absDis(a,x) + absDis(y,b);
    int telB = absDis(a,y) + absDis(x,b);
    min = min < telA ? min : telA;
    min = min < telB ? min : telB;
    cout << min;
    return 0;
}