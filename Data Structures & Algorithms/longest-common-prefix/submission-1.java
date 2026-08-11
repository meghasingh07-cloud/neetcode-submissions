class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String first= strs[0];
        for(int i=0; i<first.length();i++){
            char ch=first.charAt(i);
        
        for(int j=0; j<strs.length; j++){
            String currentWord = strs[j];
        
        if(i>=currentWord.length() || ch!= currentWord.charAt(i)){
            return first.substring(0,i);

        }
        }
        }
        return first;
    }
}