#include <iostream>

using namespace std;

int N, M, D, S;
int p[1000], m[1000], t[1000];
int sick_p[50], sick_t[50];

int main() {
    cin >> N >> M >> D >> S;

    for (int i = 0; i < D; i++) {
        int peo, ch;
        cin >> peo >> ch >> t[i];
        p[i] = peo - 1;
        m[i] = ch - 1;
    }

    for (int i = 0; i < S; i++) {
        int sp;
        cin >> sp >> sick_t[i];
        sick_p[i] = sp - 1;
    }
    int ans = 0;
    //i번쨰 치즈가 상했다고 가정하면 아픈 사람은 무조건 아프기 전에 i번째 치즈를 먹은 적이 있어야 함 
    for(int i = 0; i < M; i++) {
        bool chk = false;;
        for(int j = 0; j < S; j++) {
            chk = false;
            for(int j2 = 0; j2 < D; j2++) {
                if(p[j2] == sick_p[j] && m[j2] == i &&  t[j2] < sick_t[j]) {
                    chk = true;
                    break;
                }
            }
        }
        if(chk) {
            int* cnt = new int[N];
            for(int j = 0; j < D; j++) {
                if(m[j] == i) {
                    cnt[p[j]] = 1;
                }
            }
            int drug = 0;
            for(int j = 0; j < N; j++) {
                if(cnt[j] == 1) {
                    drug++;
                }
            }
            ans = ans > drug ? ans : drug;
            delete cnt;
        }
    }
    cout << ans;
    return 0;
}