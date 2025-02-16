class Solution {
    public int minFlipsMonoIncr(String s) {
        int cnt1 = 0, ans = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') cnt1++;
            else{
                ans = Math.min(ans+1, cnt1);
            }
        }
        return ans;
    }
}