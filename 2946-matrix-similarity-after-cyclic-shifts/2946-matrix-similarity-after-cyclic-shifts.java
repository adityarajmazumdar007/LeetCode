class Solution {

    private boolean isSame(int[] v, int k, int i){

        int[] temp = v.clone();

        if(i % 2 == 0){

            reverse(v, 0, k-1);
            reverse(v, k, v.length-1);
            reverse(v, 0, v.length-1);

        } else {

            reverse(v, 0, v.length-1);
            reverse(v, 0, k-1);
            reverse(v, k, v.length-1);
        }

        return Arrays.equals(temp, v);
    }

    private void reverse(int[] arr, int l, int r){
        while(l < r){
            int t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            l++; r--;
        }
    }

    public boolean areSimilar(int[][] mat, int k) {

        int n = mat[0].length;
        k = k % n;

        for(int i = 0; i < mat.length; i++){
            if(!isSame(mat[i], k, i)){
                return false;
            }
        }

        return true;
    }
}