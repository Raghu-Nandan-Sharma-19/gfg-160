#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maximumProfit(vector<int> &prices) {
        int maxPro = 0;
        int n = prices.size();
        int minPrice = INT_MAX;
    
        for (int i = 0; i < prices.size(); i++) {
            minPrice = min(minPrice, prices[i]);
            maxPro = max(maxPro, prices[i] - minPrice);
        }
        
        return maxPro;
    }
};

int main() {
    int n;
    cin >> n;
    vector<int> prices;
    
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        prices.push_back(x);
    }
    
    Solution sol;
    cout << sol.maximumProfit(prices) << endl;
    
    return 0;
}