class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int res=Integer.MAX_VALUE;
        for(int i=0; i<n;i++){
             int currSum=0;
             int j=i;
             while(j<n){
                currSum+=nums[j];
                if(currSum>=target){
                    res=Math.min(res, j-i+1);
                    break;
                }
                j++;
             }
        }
        return res==Integer.MAX_VALUE?0: res;
    }
}