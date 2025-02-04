class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> unlocked = new Stack<>();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == '*'){
                unlocked.push(i);
            }else if(ch == '('){
                stack.push(i);
            }else{ 
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    if(!unlocked.isEmpty()){
                        unlocked.pop();
                    }else{
                        return false;
                    }
                }
            }
        }

        while(!stack.isEmpty() && !unlocked.isEmpty() && stack.peek() < unlocked.peek()){
            stack.pop();
            unlocked.pop();
        }
        return (stack.isEmpty());
    }
}