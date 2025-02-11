#include <iostream>

using namespace std;

int N;
int x[100], y[100];

int main() {
    cin >> N;

    for (int i = 0; i < N; i++) {
        cin >> x[i] >> y[i];
    }
    int n = N;
    int ans = 1600000001;
    for(int i = 0; i < n; i++) {
        int minX = 40001;
        int minY = 40001;
        int maxX = 0;
        int maxY = 0;
        for(int j = 0; j < n; j++) {
            if(j != i) {
                if(x[j] > maxX)
                    maxX = x[j];
                if(x[j] < minX)
                    minX = x[j];
                if(y[j] > maxY)
                    maxY = y[j];
                if(y[j] < minY)
                    minY = y[j];
            }
        }
        int size = (maxX - minX) * (maxY - minY);
        ans = ans < size ? ans : size;
    }
    cout << ans;
    return 0;
}