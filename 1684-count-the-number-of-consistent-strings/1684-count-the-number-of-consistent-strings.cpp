class Solution {
public:
    int countConsistentStrings(string s, vector<string>& words) {
        unordered_set<char> st;
        for(int i=0;i<s.size();i++){
            st.insert(s[i]);
        }
 int c=0;
         for(int i=0;i<words.size();i++){
             string temp=words[i];
             int j=0;
             while(j<temp.size()){
                 if(st.count(temp[j]))j++;
                 else{break;}
             }
             if(j==temp.size()){c++;}
             
         }
    return c;}
};