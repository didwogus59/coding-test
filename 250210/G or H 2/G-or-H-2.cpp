#include <iostream>

using namespace std;

int N;
int pos[100];
char alpha[100];

int main() {
    cin >> N;

    for (int i = 0; i < N; i++) {
        cin >> pos[i] >> alpha[i];
    }

    int* arr = new int[101];
    int n = N;
    for(int i = 0; i < n; i++) {
        arr[pos[i]] = alpha[i] == 'G' ? 1 : -1;
    }
    int ans = 0;
    for(int i = 0; i < 101; i++) {
        int sum = arr[i];
        int cnt = 1;
        if(arr[i] != 0) {
            for(int j = i + 1; j < 101; j++) {
                sum += arr[j];
                if(arr[j] != 0) {
                    cnt++;
                    if(cnt == sum || -1 * cnt == sum || sum == 0) {
                        ans = ans > j - i? ans : j - i;
                    }
                }
            }
        }
    }
    cout << ans;
    return 0;
}