class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=0;
        for(int pile:piles){
            high=Math.max(high, pile);
        }
        while(low<high){
            int mid=(low+high)/2;
            if(canFinish(piles, h, mid)){
                high=mid;
            }else{
                low=mid+1;
            }
        }
        return low;
        }
        public boolean canFinish(int[] piles, int h, int k){
            int totalhours=0;
            for(int pile:piles){
                totalhours+=(pile+k-1)/k;
            }
            return totalhours<=h;
        }
        
    }

