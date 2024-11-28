#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxProduct(vector<int> &arr) {
        int n = arr.size();
        int prefix = 1, suffix = 1;
        int maxi = INT_MIN;
        
        for(int i = 0; i < n; i++) {
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;
            prefix *= arr[i];
            suffix *= arr[n - i - 1];
            maxi = max(maxi, max(prefix, suffix));
        }
        
        return maxi;
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

    Solution sol;
    cout << sol.maxProduct(arr) << endl;

    return 0;
}