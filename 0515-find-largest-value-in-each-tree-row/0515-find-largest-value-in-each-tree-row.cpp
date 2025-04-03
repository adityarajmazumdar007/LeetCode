/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<int> largestValues(TreeNode* root) {
        vector<int> answer;
        queue<TreeNode*> q;
        if(!root) return answer;
        q.push(root);
        while(!q.empty())
        {
            const int size = q.size();
            int maxi = INT_MIN;
            for(int i = 0; i < size; i++)
            {
                auto curr = q.front();
                q.pop();
                maxi = max(maxi, curr->val);
                if(curr->left) q.push(curr->left);
                if(curr->right) q.push(curr->right);
            }
            answer.push_back(maxi);
        }
        return answer;
    }
};