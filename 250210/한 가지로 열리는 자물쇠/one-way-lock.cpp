#include <iostream>

using namespace std;

int N;
int a, b, c;

int main() {
    cin >> N;
    cin >> a >> b >> c;
//3 * 4 * 5
    // Write your code here!
    int* cnt = new int[3];
    for(int i = 1; i <= N; i++) {
        if(a - i > 2 || a - i < -2)
            cnt[0]++;
        
        if(b - i > 2 || b - i < -2)
            cnt[1]++;
            
        if(c - i > 2 || c - i < -2)
            cnt[2]++;
    }
    int out = (cnt[0] * cnt[1] * cnt[2]);
    // cout << out << '\n';
    cout << (N*N*N) - out;
    return 0;
}