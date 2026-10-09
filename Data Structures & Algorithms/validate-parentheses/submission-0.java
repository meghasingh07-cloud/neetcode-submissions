class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int n=s.length();
        for(char ch : s.toCharArray()){
            if(ch =='(' || ch=='{' || ch=='['){
                stack.push(ch);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                char top=stack.pop();
                if(ch==')' && top!='(') return false;
                if(ch=='}' && top!='{') return false;
                if(ch==']' && top!='[') return false;
            }
            }
            return stack.isEmpty();
        }
        }

