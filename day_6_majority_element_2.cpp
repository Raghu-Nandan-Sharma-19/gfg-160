#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> findMajority(vector<int>& arr) {
        int cnt1 = 0, cnt2 = 0;
        int el1 = INT_MIN, el2 = INT_MIN;
        int n = arr.size();
        
        for(int i = 0; i < n; i++) {
            if(cnt1 == 0 && arr[i] != el2) {
                cnt1 = 1;
                el1 = arr[i];
            }
            else if(cnt2 == 0 && arr[i] != el1) {
                cnt2 = 1;
                el2 = arr[i];
            }
            else if(el1 == arr[i]) {
                cnt1++;
            }
            else if(el2 == arr[i]) {
                cnt2++;
            }
            else {
                cnt1--;
                cnt2--;
            }
        }
        
        vector<int> ans;
        cnt1 = 0, cnt2 = 0;
        for(int i = 0; i < n; i++) {
            if(el1 == arr[i]) {
                cnt1++;
            }
            if(el2 == arr[i]) {
                cnt2++;
            }
        }
        
        if(cnt1 >= (n / 3) + 1) {
            ans.push_back(el1);
        }
        
        if(cnt2 >= (n / 3) + 1) {
            ans.push_back(el2);
        }
        
        sort(ans.begin(), ans.end());
        
        return ans;
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
    vector<int> ans = solution.findMajority(arr);
    for(int i = 0; i < ans.size(); i++) {
        cout << ans[i] << " ";
    }
    cout << endl;

    return 0;
}