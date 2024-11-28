#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    void display(vector<int> &arr) {
        int n = arr.size();
        for(int i = 0; i < n; i++) {
            cout << arr[i] << " ";
        }
        cout << endl;
    } 

    void pushZeroesToEnd(vector<int> &arr) {
        int n = arr.size();
        int j = -1;
        
        for(int i = 0; i < n; i++) {
            if(arr[i] == 0) {
                j = i;
                break;
            }
        }

        if(j == -1) {
            return;
        }

        for(int i = j + 1; i < n; i++) {
            if(arr[i] != 0) {
                swap(arr[i], arr[j]);
                j++;
            }
        }
    }
};

int main() {
    int n;
    cin >> n;
    vector<int> arr;

    for(int i = 0; i < n; i++) {
        int x;
        cin >> x;
        arr.push_back(x);
    }

    Solution solution;
    solution.pushZeroesToEnd(arr);
    solution.display(arr);

    return 0;
}