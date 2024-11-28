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

    void rotateArr(vector<int> &arr, int d) {
        int n = arr.size();
        reverse(arr.begin(), arr.begin() + d);
        reverse(arr.begin() + d, arr.end());
        reverse(arr.begin(), arr.end());
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

    int d;
    cin >> d;

    Solution solution;
    solution.rotateArr(arr, d);
    solution.display(arr);

    return 0;
}