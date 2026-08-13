class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] output= new int[n];
        int leftproduct=1;
        for(int i=0; i<n;i++){
            output[i]=leftproduct;
            leftproduct*=nums[i];
        }
        int rightproduct=1;
        for(int i=n-1; i>=0;i--){
            output[i]*=rightproduct;
            rightproduct*=nums[i];
        
        }
        return output;
        
    }
}  
