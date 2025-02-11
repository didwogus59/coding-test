#include <iostream>

using namespace std;

int n;
int a[10], b[10], c[10];

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> a[i] >> b[i] >> c[i];
    }
    int cnt = 0;
    for(int i = 100; i <= 999; i++) {
        int o1 = i % 10;
        int t1 = (i / 10) % 10;
        int h1 = i / 100;
        bool chk = true;
        
        if(o1 != t1 && t1 != h1 && o1 != h1) {
            for(int j = 0; j < n; j++) {
                int p1 = 0;
                int p2 = 0;
                int o2 = a[j] % 10;
                int t2 = (a[j] / 10) % 10;
                int h2 = a[j] / 100;

                if(o1 == o2)
                    p1++;
                if(t1 == t2)
                    p1++;
                if(h1 == h2)
                    p1++;
                if(o1 == t2 || o1 == h2)
                    p2++;
                if(t1 == o2 || t1 == h2)
                    p2++;
                if(h1 == o2 || h1 == t2)
                    p2++;

                if(p1 != b[j] || p2 != c[j]) {
                    chk = false;
                    break;
                }
            }
            if(chk)
                cnt++;
        }
    }
    // Write your code here!
    cout << cnt;
    return 0;
}