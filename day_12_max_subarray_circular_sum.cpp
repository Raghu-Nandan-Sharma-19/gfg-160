#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int circularSubarraySum(vector<int> &arr) {
        int totalSum = 0;
        int currMaxSum = 0, currMinSum = 0;
        int maxSum = arr[0], minSum = arr[0];
    
        for (int i = 0; i < arr.size(); i++) {
            currMaxSum = max(currMaxSum + arr[i], arr[i]);
            maxSum = max(maxSum, currMaxSum);
    
            currMinSum = min(currMinSum + arr[i], arr[i]);
            minSum = min(minSum, currMinSum);
    
            totalSum = totalSum + arr[i];
        }
    
        int normalSum = maxSum;
        int circularSum = totalSum - minSum;

        if (minSum == totalSum) return normalSum;
    
        return max(normalSum, circularSum);
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
    cout << sol.circularSubarraySum(arr) << endl;

    return 0;
}