class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        
        for (String s : strs) {
            // Append: length + '#' + string
            sb.append(s.length()).append('#').append(s);
        }
        
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        
        while (i < s.length()) {
            // Find the position of the delimiter '#'
            int slashIndex = s.indexOf('#', i);
            
            // Extract the length of the next string
            int length = Integer.parseInt(s.substring(i, slashIndex));
            
            // Calculate start and end indices of the actual string
            int start = slashIndex + 1;
            int end = start + length;
            
            // Extract the string and add to result
            result.add(s.substring(start, end));
            
            // Move pointer to the start of the next chunk
            i = end;
        }
        return result;
    }
}
