class Solution {
    public int majorityElement(int[] nums) {
        int n= nums.length;
        int majEl=0;
        int cnt=0;
        for(int i=0; i<n;i++){
            if(cnt==0){
                majEl=nums[i];
            }
            if(majEl==nums[i]){
                cnt++;
            }else{
                cnt--;
            }
        }
        return majEl;
    }
}