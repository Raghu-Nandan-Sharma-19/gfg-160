#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maximumProfit(vector<int>& prices) {
        int n = prices.size();
        int lMin = prices[0];
        int lMax = prices[0];
        int res = 0;
      
        int i = 0;
        while(i < n - 1) { 
            while(i < n - 1 && prices[i] >= prices[i + 1]) { 
                i++; 
            }
            lMin = prices[i];
           
            while(i < n - 1 && prices[i] <= prices[i + 1]) { 
                i++; 
            }

            lMax = prices[i];
            res = res + (lMax - lMin);
        }
      
        return res;
    }
};

int main() {
    int n;
    cin >> n;
    vector<int> prices;

    for(int i = 0; i < n; i++) {
        int x;
        cin >> x;
        prices.push_back(x);
    }

    Solution solution;
    cout << solution.maximumProfit(prices) << endl;

    return 0;
}