#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    void display(vector<int> &A) {
        int n = A.size();
        for (int i = 0; i < n; i++) {
            cout << A[i] << " ";
        }
        cout << endl;
    }

    void nextPermutation(vector<int> &A) {
        int n = A.size();

        int ind = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] < A[i + 1]) {
                ind = i;
                break;
            }
        }

        if (ind == -1) {
            reverse(A.begin(), A.end());
            return;
        }

        for (int i = n - 1; i > ind; i--) {
            if (A[i] > A[ind]) {
                swap(A[i], A[ind]);
                break;
            }
        }
        
        reverse(A.begin() + ind + 1, A.end());
    }
};

int main() {
    int n;
    cin >> n;
    vector<int> arr;

    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        arr.push_back(x);
    }

    Solution solution;
    solution.nextPermutation(arr);
    solution.display(arr);

    return 0;
}