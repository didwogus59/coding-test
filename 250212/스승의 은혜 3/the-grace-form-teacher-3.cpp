#include <iostream>
#include <algorithm>
using namespace std;
struct pd {
    int p;
    int s;
    pd(){}
    pd(int p, int s) {
        this->p = p;
        this->s = s;
    }
};

bool compare(pd a, pd b) {
    return a.p+a.s < b.p+b.s;
}

int N, B;
int P[1000];
int S[1000];
pd st[1000];
int main() {
    cin >> N >> B;

    for (int i = 0; i < N; i++) {
        cin >> P[i] >> S[i];
        st[i] = pd(P[i], S[i]);
    }
    sort(st, st + N, compare);
    int ans = 0;
    for(int i = 0; i < N; i++) {
        int sum = st[i].p / 2 + st[i].s;
        if(sum > B)
            continue;
        int cnt = 1;
        for(int j = 0; j < N; j++) {
            if(i != j) {
                int now = st[j].p + st[j].s;
                if(sum + now <= B) {
                    sum += now;
                    cnt++;
                }
            }
        }
        ans = ans > cnt ? ans : cnt;
    }
    cout << ans;
    return 0;
}