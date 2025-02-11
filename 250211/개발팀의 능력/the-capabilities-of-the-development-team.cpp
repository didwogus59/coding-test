#include <iostream>

using namespace std;

int ab[5];
int ans = 6000000;
int diff(int a, int b, int c) {
    int max;
    int min;
    if(a > b) {
        if(a > c) {
            max = a; 
        }
        else {
            max = c;
        }
        if(c > b) {
            min = b;
        }
        else
            min = c;
    }
    else {
        if(b > c) {
            max = b;
        }
        else {
            max = c;
        }
        if(c > a) {
            min = a;
        }
        else
            min = c;
    }
    return max - min;
}
void make_arr(int* ab, int* chk, int* arr, int now) {
    if(now == 5) {
        int a = ab[arr[0]] + ab[arr[1]];
        int b = ab[arr[2]] + ab[arr[3]];
        int c = ab[arr[4]];
        if(a != b && b != c && c != a) {
            int d = diff(a,b,c);
            ans = ans < d ? ans : d;
        }
    }
    else {
        for(int i = 0; i < 5; i++) {
            if(chk[i] == 0) {
                chk[i] = 1;
                arr[now] = i;
                make_arr(ab, chk, arr, now + 1);
                chk[i] = 0;
            }
        }
    }
}
int main() {
    int sum = 0;
    for (int i = 0; i < 5; i++) {
        cin >> ab[i];
        sum += ab[i];
    }
    ans = sum;
    int* chk = new int[5];
    int* arr = new int[5];
    make_arr(ab, chk, arr, 0);
    cout << ans;
    return 0;
}