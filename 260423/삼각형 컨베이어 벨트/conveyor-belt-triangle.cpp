#include <iostream>
#include <list>
using namespace std;

int main() {

    list<int> list1;
    list<int> list2;
    list<int> list3;

    int n, m;
    cin >> n >> m;

        for (int j = 0; j < n; j++) {
            int tmp;
            cin >> tmp;
            list1.push_back(tmp);
        }
        for (int j = 0; j < n; j++) {
            int tmp;
            cin >> tmp;
            list2.push_back(tmp);
        }
        for (int j = 0; j < n; j++) {
            int tmp;
            cin >> tmp;
            list3.push_back(tmp);
        }
    for (int i = 0; i < m; i++) {
        
        int tmp1 = list1.back();
        list1.pop_back();
        int tmp2 = list2.back();
        list2.pop_back();
        int tmp3 = list3.back();
        list3.pop_back();

        list1.push_front(tmp3);
        list2.push_front(tmp1);
        list3.push_front(tmp2);
    }

    for (int num : list1) {
        cout << num << " ";
    }
    cout << endl;
    for (int num : list2) {
        cout << num << " ";
    }
    cout << endl;
    for (int num : list3) {
        cout << num << " ";
    }
    return 0;
}