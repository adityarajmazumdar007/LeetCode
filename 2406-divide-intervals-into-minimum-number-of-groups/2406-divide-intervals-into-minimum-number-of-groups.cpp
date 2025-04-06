class Solution {
public:
    int minGroups(vector<vector<int>>& arr) {
          int n = arr.size();
        
        // sort the array on the basis of start in increasing order
        
        sort(arr.begin(), arr.end());
        
        // declare a min heap, which will store the ending value of every group till ith index
        
        priority_queue<int, vector<int>, greater<int>> pq;
        
        pq.push(arr[0][1]);
        
        // now iterate over array and make possible groups
        
        for(int i = 1; i < n; i++)
        {
            // start value is greater than end value, then we can include the curr interval in this group
            
            if(arr[i][0] > pq.top())
            {
                pq.pop();
            }
            
            // push the end value in the pq
            
            pq.push(arr[i][1]);
        }
        
        return pq.size();
    }
};