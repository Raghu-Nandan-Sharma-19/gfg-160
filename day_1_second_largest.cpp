#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int getSecondLargest(vector<int> &arr) {
        int largest = arr[0], sLargest = -1;
        int n = arr.size();
        
        for(int i = 1; i < n; i++) {
            if(arr[i] > largest) {
                sLargest = largest;
                largest = arr[i];
            }
            else if(arr[i] != largest && arr[i] > sLargest) {
                sLargest = arr[i];
            }
        }
        
        return sLargest;
    }
};

int main() {
    int n;
    cin >> n;
    vector<int> nums;

    for(int i = 0; i < n; i++) {
        int x;
        cin >> x;
        nums.push_back(x);
    }

    Solution solution;
    cout << solution.getSecondLargest(nums) << endl;

    return 0;
}