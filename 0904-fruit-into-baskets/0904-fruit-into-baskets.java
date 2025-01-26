class Solution {
    public int totalFruit(int[] fruits) {
        int i=0;
        int j=0;
        int maxi=0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        while(j<fruits.length){
            mp.put(fruits[j],mp.getOrDefault(fruits[j],0)+1);
            while(mp.size()>2){
                mp.put(fruits[i],mp.getOrDefault(fruits[i],0)-1);
                if(mp.get(fruits[i])==0)mp.remove(fruits[i]);
                i++;
            }
            if(mp.size()<=2)maxi=Math.max(maxi,j-i+1);
            j++;
        }
        return maxi;
    }
}