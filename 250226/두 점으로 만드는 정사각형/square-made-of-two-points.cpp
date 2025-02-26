#include <iostream>

using namespace std;

int x1, y1, x2, y2;
int a1, b1, a2, b2;

int main() {
    cin >> x1 >> y1 >> x2 >> y2;
    cin >> a1 >> b1 >> a2 >> b2;
    int min[2]{};
    int max[2]{};
    min[0] = x1;
    min[1] = y1;
    max[0] = x2;
    max[1] = y2;
    min[0] = min[0] < a1 ? min[0] : a1;
    min[1] = min[1] < b1 ? min[1] : b1;
    
    max[0] = max[0] > a2 ? max[0] : a2;
    max[1] = max[1] > b2 ? max[1] : b2;

    int dis = max[0] - min[0];
    dis = dis > max[1] - min[1] ? dis : max[1] - min[1];

    cout << dis*dis;
    
    // Please write your code here.

    return 0;
}