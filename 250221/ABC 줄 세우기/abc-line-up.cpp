#include <iostream>

using namespace std;

int n;
int arrP[26];

int arrM[26];

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        char tmp;
        cin >> tmp;
        arrP[i] = (int)(tmp - 'A');
        
        arrM[i] = (int)(tmp - 'A');
    }
    // Write your code here!
    int ans;
    int cnt = 0;
    for(int i = n - 1; i >= 0; i--) {
        int max = -1;
        int p = -1;
        for(int j = 0; j <= i; j++) {
            if(arrP[j] > max) {
                max = arrP[j];
                p = j;
            }
        }
        for(int j = p; j < i; j++) {
            int tmp = arrP[j];
            arrP[j] = arrP[j+1];
            arrP[j+1] = tmp;
        }
        cnt += i - p;
    }
    ans = cnt;
    cout << ans;
    return 0;
}