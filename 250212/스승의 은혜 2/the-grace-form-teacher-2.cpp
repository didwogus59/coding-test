#include <iostream>
#include <algorithm>
using namespace std;

int n, b;
int p[1000];

int main() {
    cin >> n >> b;

    for (int i = 0; i < n; i++) {
        cin >> p[i];
    }
    int ans = 0;
    
    sort(p, p + n);

    for(int i = 0; i < n; i++) {
        int save = p[i];
        p[i] = 0;
        int sum = save / 2;
        int cnt = 1;
        for(int j = 0; j < n; j++) {
            if(j != i) {
                if(sum + p[j] <= b) {
                    sum += p[j];
                    cnt++;
                } 
                else
                    break;
            }
        }
        ans = ans > cnt ? ans : cnt;
        p[i] = save;
    }

    // Write your code here!
    cout << ans;
    return 0;
}