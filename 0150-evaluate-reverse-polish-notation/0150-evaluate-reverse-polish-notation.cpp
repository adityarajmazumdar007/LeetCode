class Solution {
public:
    int evalRPN(vector<string>& t) {
      stack<int>st;
        for(int i=0;i<t.size();i++){
            if(t[i]=="+"||t[i]=="-"||t[i]=="*"||t[i]=="/"){
                int x1= st.top();st.pop();
                int x2=st.top();st.pop();
                if(t[i]=="+")st.push(x1+x2);
                else if(t[i]=="-")st.push(x2-x1);
                else if(t[i]=="*")st.push(x1*x2);
                else{st.push(x2/x1);}
            }
            else{st.push(stoi(t[i]));}
        }
    return st.top();}
};