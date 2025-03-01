class Solution {
    public int numDistinct(String S, String T) {
    int[][] mem = new int[S.length()+1][T.length()+1];
    for(int j=0; j<=S.length(); j++) {
        mem[j][0] = 1;
    }
    

    
    for(int i=1; i<=S.length(); i++) {
        for(int j=1; j<=T.length(); j++) {
            if(S.charAt(i-1) == T.charAt(j-1)) {
                mem[i][j] = mem[i-1][j-1] + mem[i-1][j];
            } else {
                mem[i][j] = mem[i-1][j];
            }
        }
    }
    
    return mem[S.length()][T.length()];
}
}