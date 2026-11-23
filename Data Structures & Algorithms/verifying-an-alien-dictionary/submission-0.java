class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] rank=new int[26];
        int n=order.length();
        for(int i=0; i<n;i++){
            rank[order.charAt(i) - 'a'] = i;
        }
        for(int i=0; i<words.length-1;i++){
            String first = words[i];
            String second = words[i+1];
            int len=Math.min(first.length(),second.length());
            for(int j=0; j<len; j++){
                if(first.charAt(j)!=second.charAt(j)){
                    if(rank[first.charAt(j)-'a']> rank[second.charAt(j)-'a']){
                        return false;
                    }
                    break;
                }
            }
            if(first.length()>second.length() && first.startsWith(second)){
                return false;
            }
        }
        return true;

    }
}