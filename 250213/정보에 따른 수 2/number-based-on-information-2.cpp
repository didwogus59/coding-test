#include <iostream>
#include <vector>
using namespace std;

int T, a, b;

int main() {
    cin >> T >> a >> b;
    vector<int> alp1;
    vector<int> alp2;
    for (int i = 0; i < T; i++) {
        char tmp;
        int pt;
        cin >> tmp >> pt;
        if(tmp == 'S') {
            alp1.push_back(pt);
        }
        else {
            alp2.push_back(pt);
        }
    }

    int cnt = 0;
    for(int i = a; i <= b; i++) {
        int dis1 = b;
        int dis2 = b;
        for(int pt : alp1) {
            int dis = i - pt;
            if(dis < 0) {
                dis *= -1;
            }
            dis1 = dis1 < dis ? dis1 : dis;
        }
        
        for(int pt : alp2) {
            int dis = i - pt;
            if(dis < 0) {
                dis *= -1;
            }
            dis2 = dis2 < dis ? dis2 : dis;
        }
        if(dis1 <= dis2) {
            cnt++;
        }
            
    }
    cout << cnt;

    // Write your code here!

    return 0;
}