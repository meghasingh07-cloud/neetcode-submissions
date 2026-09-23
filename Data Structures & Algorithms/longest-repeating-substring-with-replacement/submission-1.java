class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int left=0;
        int maxfrequency=0;
        int res=0;
        HashMap<Character, Integer> freq= new HashMap<>();
        for(int right=0; right<n; right++){
            char ch=s.charAt(right);
            freq.put(ch,freq.getOrDefault(ch,0)+1);
            maxfrequency=Math.max(maxfrequency, freq.get(ch));
            while((right-left+1)-maxfrequency>k){
                char leftChar=s.charAt(left);
                freq.put(leftChar, freq.get(leftChar)-1);
                left++;
            }
             res = Math.max(res, right - left + 1);
        }
        return res;
        
    }
}
