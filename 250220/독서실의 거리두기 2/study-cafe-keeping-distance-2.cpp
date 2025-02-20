#include<iostream>

using namespace std;

int main() {
    int n;
    cin >> n;
    string str;
    cin >> str;
    int arr[1001];
    for(int i = 0; i < n; i++) {
        if(str[i] == '0') {
            arr[i]= 0;
        }
        else
            arr[i] = 1;
    }
    int max = 0;
    for(int i = 0; i < n; i++) {
        if(arr[i] == 0) {
            arr[i] = 1;
            int bef = -1;
            int min = 1001;
            for(int j = 0; j < n; j++) {
                if(arr[j] == 1) {
                    if(bef == -1) {
                        bef = j;
                    }
                    else {
                        if(min > j - bef) {
                            min = j - bef;
                        }
                        bef = j;
                    }
                }
            }
            max = max > min ? max : min;
            arr[i] = 0;
        }
    }

    cout << max;
    return 0;
}