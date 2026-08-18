class Solution {
    public int subarraySum(int[] nums, int k) {
       int cnt=0;
       int sum=0;
       Map<Integer,Integer> prefix= new HashMap<>();
       prefix.put(0,1);
       for(int num: nums){
        sum+=num;
        if(prefix.containsKey(sum-k)){
            cnt+=prefix.get(sum-k);
        }
        prefix.put(sum, prefix.getOrDefault(sum,0)+1);
       }
       return cnt;

    }
}