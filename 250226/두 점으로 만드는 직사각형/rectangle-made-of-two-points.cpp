#include<iostream>
using namespace std;

int main() {

    int minX;
    int maxX;
    int minY;
    int maxY;

    int x1,y1,x2,y2;
    cin >> x1 >> y1 >> x2 >> y2;
    minX = x1;
    minY = y1;
    maxX = x2;
    maxY = y2;
    cin >> x1 >> y1 >> x2 >> y2;
    minX = minX < x1 ? minX : x1;
    maxX = maxX > x2 ? maxX : x2;
    minY = minY < y1 ? minY : y1;
    maxY = maxY > y2 ? maxY : y2;
    cout << (maxX - minX) * (maxY - minY);
    return 0;
}