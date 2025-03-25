class Solution {
public:
    bool check(string &a, string &b){
        int count =0;
        for(int i=0;i<a.size();i++){
            if(a[i]!=b[i])count++;
        }
        return (count ==2|| count ==0);
    }
    
    void dfs(int i, vector<bool> &visited,vector<string>& strs ){
        visited[i]=true;
        for(int j=0;j<strs.size();j++){
            if(visited[j])continue;
            if(check(strs[i],strs[j])){dfs(j,visited,strs);}
        }
    }
    
    int numSimilarGroups(vector<string>& strs) {
        int groups=0;
        vector<bool>visited(strs.size(),false);
        for(int i=0;i<strs.size();i++){
            if(!visited[i]){
                groups++;
                dfs(i,visited,strs);
            }
        }
    return groups;}
};