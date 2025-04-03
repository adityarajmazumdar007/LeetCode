class Solution {
    public int minSwaps(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='[')st.push('[');
            else{
                if(st.size()==0 || st.peek()==']')st.push(']');
                else{st.pop();}
            }
        }
        return (int)(st.size()/2+1)/2;
    }
}