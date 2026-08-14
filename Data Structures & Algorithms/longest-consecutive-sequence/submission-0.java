class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int longestStreak=0;
        Set<Integer> numset = new HashSet<>();
        for(int num: nums){
            numset.add(num);
        }
        for(int num:nums){
            if(!numset.contains(num-1)){
                int currentnum=num;
                int currentstreak=1;
        
        while(numset.contains(currentnum+1)){
            currentnum += 1;
            currentstreak +=1;
        }
        
        longestStreak=Math.max(longestStreak, currentstreak);
        
        }
        
        
        
    }
    return longestStreak;
    }
}


