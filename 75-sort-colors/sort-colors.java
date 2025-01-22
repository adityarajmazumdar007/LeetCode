class Solution {
    public void sortColors(int[] arr) {
        int low=0;
        int mid=0;
        int high =arr.length-1;
        while(mid<=high){
            int num=arr[mid];
            if(num==0){
                int temp=arr[low];
                arr[low++]=arr[mid];
                arr[mid++]=temp;
            }
            else if(num==1){mid++;}
            else{
                int temp=arr[high]; 
                arr[high--]=arr[mid];
                arr[mid]=temp;
            }
        }
        return;
    }
}