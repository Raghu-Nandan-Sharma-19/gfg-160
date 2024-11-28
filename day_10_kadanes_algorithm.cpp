#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxSubarraySum(vector<int> &arr) {
        int n = arr.size();
        long long sum = 0, maxi = INT_MIN;
        
        for(int i = 0; i < n; i++) {
            sum += arr[i];
            if(sum > maxi) {
                maxi = max(sum, maxi);
            }
            if(sum < 0) {
                sum = 0;
            }
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
    cout << sol.maxSubarraySum(arr) << endl;

    return 0;
}