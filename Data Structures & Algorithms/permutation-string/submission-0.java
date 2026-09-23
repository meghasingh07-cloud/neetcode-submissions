class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n=s1.length();
        int left=0;
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();
        for(int i=0; i<n; i++){
            char ch1=s1.charAt(i);
            map1.put(ch1,map1.getOrDefault(ch1,0)+1);
        }
        for(int right=0;right<s2.length();right++){
            char ch2=s2.charAt(right);
            map2.put(ch2,map2.getOrDefault(ch2,0)+1);
            if((right-left+1)>n){
                char charLeft=s2.charAt(left);
                map2.put(charLeft,map2.get(charLeft)-1);

                if(map2.get(charLeft)==0){
                    map2.remove(charLeft);
                }
            left++;
}
            if (map1.equals(map2)) {
                return true;
    }
        }
    return false;
    }
}
    