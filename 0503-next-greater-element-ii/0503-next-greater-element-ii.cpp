class Solution {
public:
	vector<int> nextGreaterElements(vector<int>& arr) {
		stack<int> s;
		vector<int> v;
		for(int i=arr.size()-1;i>=0;i--)
		{
			s.push(arr[i]);

		}
int n=arr.size();
		for(    int i=n-1;i>=0;i--){
        if(s.size()==0){
            v.push_back(-1);
        }
        else if(s.size()>0&& s.top()>arr[i]){
            v.push_back(s.top());
        }
        else if(s.size()>0 && s.top()<=arr[i]){
            while(s.size()>0 && s.top()<=arr[i]){s.pop();}
            if(s.size()==0){v.push_back(-1);}
            else{
                v.push_back(s.top());
            }
        }
   s.push(arr[i]); }
  reverse(v.begin(),v.end());
  return v ; }
};