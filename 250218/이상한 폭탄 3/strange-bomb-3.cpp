#include<iostream>

using namespace std;

int main() {
    int n, k;
    cin >> n >> k;

    int* bomb = new int[n];
    int* boom = new int[n];
    for(int i = 0; i < n; i++) {
        cin >> bomb[i];
    }
    int max = 0;
    int num = 0;
    for(int i = 0; i < n; i++) {
        for(int j = 1; j <= bomb[i]; j++) {
            if(i + j < n) {
                if(bomb[i + j] == bomb[i]) {
                    boom[i + j] = 1;
                    boom[i] = 1;
                }
            }
            if(i - j >= 0) {
                if(bomb[i - j] == bomb[i]) {
                    boom[i - j] = 1;
                    boom[i] = 1;
                }
            }
        }
    }
    for(int i = 0; i < n; i++) {
        if(boom[i] == 1) {
            int cnt = 0;
            for(int j = 0; j < n; j++) {
                if(bomb[i] == bomb[j]) {
                    if(boom[j] == 1) {
                        cnt++;
                    }
                }
            }
            if(cnt > max) {
                max = cnt;
                num = bomb[i];
            }
            else if(cnt == max) {
                if(bomb[i] > num)
                    num = bomb[i];
            }
        }
    }
    if(max != 0)
        cout << num;
    else
        cout << 0;
    return 0;
}