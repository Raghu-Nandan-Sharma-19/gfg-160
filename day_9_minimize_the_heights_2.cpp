#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int getMinDiff(vector<int> &arr, int k) {
        int n = arr.size();
        if (n == 1) return 0;
            
        sort(arr.begin(), arr.end());
        int result = arr[n - 1] - arr[0];

        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;

        for (int i = 0; i < n - 1; i++) {
            int minHeight = min(smallest, arr[i + 1] - k);
            int maxHeight = max(largest, arr[i] + k);            
            if (minHeight < 0) continue;

            result = min(result, maxHeight - minHeight);
        }
        return result;
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

    int k;
    cin >> k;
    Solution sol;
    cout << sol.getMinDiff(arr, k) << endl;
    
    return 0;
}