#include <iostream>
using namespace std;

int cal(int x1, int x2, int y1, int y2, int** arr) {
    int sum = 0;
    for(int i = x1; i <= x2; i++) {
        for(int j = y1; j <= y2; j++) {
            sum += arr[i][j];
        }
    }
    return sum;
}
int main() {
    // Please write your code here.
    int h, w;
    cin >> h >> w;

    int** arr = new int*[h];
    for(int i = 0; i < h; i++) {
        arr[i] = new int[w];
        for(int j = 0; j < w; j++) {
            cin >> arr[i][j]; 
        }
    }
    int ans = -250000;
    for(int x1 = 0; x1 < h; x1++) {
        for(int x2 = x1; x2 < h; x2++) {
            for(int y1 = 0; y1 < w; y1++) {
                for(int y2 = y1; y2 < w; y2++) {
                    int sum = cal(x1,x2,y1,y2,arr);
                    int tmp = -250000;
                    for(int tx1 = 0; tx1 < h; tx1++) {
                        for(int tx2 = tx1; tx2 < h; tx2++) {
                            for(int ty1 = y2 + 1; ty1 < w; ty1++) {
                                for(int ty2 = ty1; ty2 < w; ty2++) {
                                    int result = cal(tx1, tx2, ty1, ty2, arr);
                                    tmp = tmp > result ? tmp : result;
                                }
                            }
                        }
                    }
                    for(int tx1 = x2 + 1; tx1 < h; tx1++) {
                        for(int tx2 = tx1; tx2 < h; tx2++) {
                            for(int ty1 = 0; ty1 < w; ty1++) {
                                for(int ty2 = ty1; ty2 < w; ty2++) {
                                    int result = cal(tx1, tx2, ty1, ty2, arr);
                                    tmp = tmp > result ? tmp : result;
                                }
                            }
                        }
                    }
                    sum += tmp;
                    ans = ans > sum ? ans : sum;
                }
            }
        }
    }
    cout << ans;
    return 0;
}