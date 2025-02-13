#include <iostream>

using namespace std;

int T, a, b;
int x[100];
int* alp1;
int* alp2;
int main() {
    cin >> T >> a >> b;
    alp1 = new int[101]{};
    alp2 = new int[101]{};
    for (int i = 0; i < T; i++) {
        char tmp;
        int pt;
        cin >> tmp >> pt;
        if(tmp == 'S') {
            alp1[pt] = 1;
        }
        else {
            alp2[pt] = 1;
        }
    }

    int cnt = 0;
    for(int i = a; i <= b; i++) {
        int dis1 = b;
        int dis2 = b;
        for(int j = a; j <= b; j++) {
            
            int dis = i - j;
            if(i < j) {
                dis *= -1;
            }
            if(alp1[j] == 1) {
                dis1 = dis1 < dis ? dis1 : dis;
            }
            if(alp2[j] == 1) {
                dis2 = dis2 < dis ? dis2 : dis;
            }
        }
        if(dis1 <= dis2) {
            cnt++;

        }
            
    }
    cout << cnt;

    // Write your code here!

    return 0;
}