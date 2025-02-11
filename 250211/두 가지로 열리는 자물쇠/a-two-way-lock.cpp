#include <iostream>

using namespace std;

int N;
int a1, b1, c1;
int a2, b2, c2;

int main() {
    cin >> N;
    cin >> a1 >> b1 >> c1;
    cin >> a2 >> b2 >> c2;

    int* cnt = new int[9];
    int* a = new int[N + 1];
    int* aa = new int[N + 1];
    int* b = new int[N + 1];
    int* bb = new int[N + 1];
    int* c = new int[N + 1];
    int* cc = new int[N + 1];
    // -1 -> n - 1 
    //-2 -> n - 2
    // n -> 0
    // n + 1 -> 1
    for(int i = -2; i < 3; i++) {
        a[(a1 + i + 3*N) % N] = 1;
        aa[(a2 + i + 3*N) % N] = 1;
        b[(b1 + i + 3*N) % N] = 1;
        bb[(b2 + i + 3*N) % N] = 1;
        c[(c1 + i + 3*N) % N] = 1;
        cc[(c2 + i + 3*N) % N] = 1;
    }
    for(int i = 0; i < N; i++) {
        if(a[i] == 1) {
            cnt[0]++;
        }
        if(aa[i] == 1) {
            cnt[3 + 0]++;
        }
        if(a[i] == 1 && aa[i] == 1){
            cnt[6 + 0]++;
        }
        if(b[i] == 1) {
            cnt[2]++;
        }
        if(bb[i] == 1) {
            cnt[3 + 2]++;
        }
        if(b[i] == 1 && bb[i] == 1){
            cnt[6 + 2]++;
        }
        if(c[i] == 1) {
            cnt[1]++;
        }
        if(cc[i] == 1) {
            cnt[3 + 1]++;
        }
        if(c[i] == 1 && cc[i] == 1){
            cnt[6 + 1]++;
        }
    }

    cout << (cnt[0] * cnt[1] * cnt[2]) + (cnt[3] * cnt[4] * cnt[5]) - (cnt[6] * cnt[7] * cnt[8]);
    return 0;
}