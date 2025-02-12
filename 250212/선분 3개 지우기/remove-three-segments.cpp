#include <iostream>

using namespace std;

int n;
int l[10], r[10];

int main() {
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> l[i] >> r[i];
    }
    int ans = 0;
    for(int i = 0; i < n - 2; i++) {
        for(int j = i + 1; j < n - 1; j++) {
            for(int p = j + 1; p < n; p++) {
                int* line = new int[101]{};
                for(int q = 0; q < n; q++) {
                    if(q != i && q != j && q != p) {
                        for(int t = l[q]; t <= r[q]; t++) {
                            line[t]++;
                        }
                    }
                }
                bool chk = true;
                for(int q = 0; q < 101; q++) {
                    if(line[q] > 1) {
                        chk = false;
                        break;
                    }
                }
                if(chk)
                    ans++;
                delete[] line;
            }
        }
    }
    cout << ans;
    return 0;
}