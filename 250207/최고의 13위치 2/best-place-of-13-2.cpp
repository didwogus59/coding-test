#include <iostream>
#include <algorithm>
using namespace std;

int N;
int arr[20][20];

int main() {
    cin >> N;
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++) cin >> arr[i][j];

    // Write your code here!
    int n = N;
    int* line_max = new int[n];
    for(int i = 0; i < n; i++) {
        int max = arr[i][0] + arr[i][1] + arr[i][2];
        int now = max;
        for(int j = 3; j < n; j++) {
            now = now + arr[i][j] - arr[i][j-3];
            max = max > now ? max : now;
        }
        line_max[i] = max;
    }
    sort(line_max, line_max + n);
    int ans = line_max[n-1] + line_max[n-2];
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n - 3; j++) {
            int now = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
            for(int p = j + 3; p < n; p++) {
                int now2 = arr[i][p] + arr[i][p+1] + arr[i][p+2];
                ans = ans > now + now2 ? ans : now + now2;
            }
        }
    }
    cout << ans;
    return 0;
}