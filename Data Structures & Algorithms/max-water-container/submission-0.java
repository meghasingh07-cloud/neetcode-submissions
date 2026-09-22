class Solution {
    public int maxArea(int[] heights) {
        int n=heights.length;
        int left=0;
        int right=n-1;
        int maxWater=0;
        while(left<right){
            int width=right-left;
            int height=Math.min(heights[left],heights[right]);
            int water=width*height;
            maxWater= Math.max(maxWater, water);
        if(heights[left]<heights[right]){
            left++;
        }else{
            right--;
        }
        }
        return maxWater;
    }
}
