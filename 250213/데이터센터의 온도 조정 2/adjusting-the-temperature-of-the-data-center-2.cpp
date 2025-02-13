#include <iostream>

using namespace std;

int N, C, G, H;
int Ta[1000], Tb[1000];

int main() {
    cin >> N >> C >> G >> H;
    int max = 0;
    int min = 2000;
    for (int i = 0; i < N; i++) {
        cin >> Ta[i] >> Tb[i];
        max = max > Tb[i] ? max : Tb[i];
        min = min < Ta[i] ? min : Ta[i];
    }
    int ans = 0;
    for(int i = min - 1; i < max + 2; i++) {
        int sum = 0;
        for(int j = 0; j < N; j++) {
            if(i < Ta[j]) {
                sum += C;
            }
            else if(i <= Tb[j]) {
                sum += G;
            }
            else {
                sum += H;
            }
        }
        ans = ans > sum ? ans : sum;
    }
    cout << ans;
    // Write your code here!

    return 0;
}