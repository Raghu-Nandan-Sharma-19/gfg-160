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

    void reverseArray(vector<int> &arr) {
        int n = arr.size();
        int left = 0, right = n - 1;

        while(left < right) {
            swap(arr[left], arr[right]);
            left++;
            right--;
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
    solution.reverseArray(arr);
    solution.display(arr);

    return 0;
}