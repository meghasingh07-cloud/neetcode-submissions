

class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        
        if (n < m) return "";

        int minLen = Integer.MAX_VALUE;
        int minStart = 0; // To keep track of where the best substring starts
        
        // 1. Store t's character frequencies
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        // Number of unique characters in t that need to be matched
        int required = map.size(); 
        
        int left = 0;
        int right = 0;
        int formed = 0;
        
        // Map to keep track of character counts in our current sliding window
        HashMap<Character, Integer> windowMap = new HashMap<>();
        
        // 2. Expand window with 'right' pointer
        while (right < n) {
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
            
            // If the current character's frequency matches its requirement in t, increment formed
            if (map.containsKey(c) && windowMap.get(c).intValue() == map.get(c).intValue()) {
                formed++;
            }
            
            // 3. Contract window with 'left' pointer when valid
            while (left <= right && formed == required) {
                // Update minimum length and start position if we found a smaller window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                
                // Character to be removed from the left
                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                
                // If removing it breaks the requirement, decrement formed
                if (map.containsKey(leftChar) && windowMap.get(leftChar).intValue() < map.get(leftChar).intValue()) {
                    formed--;
                }
                
                left++; // Shrink window from left
            }
            
            right++; // Expand window to the right
        }
        
        // If minLen was never updated, no valid window exists
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}