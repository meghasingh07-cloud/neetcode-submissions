class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> st=new HashSet<>();
        int len=wordList.size();
        for(int i=0;i<len;i++){
            st.add(wordList.get(i));
        }

        Queue<ArrayList<String>> q=new LinkedList<>();
        ArrayList<String> ls= new ArrayList<>();
        ls.add(beginWord);
        q.add(ls);

        ArrayList<String> usedOnLevel= new ArrayList<>();
        usedOnLevel.add(beginWord);
        int level=0;

        //ArrayList<ArrayList<String>> ans= new ArrayList<>();
        while(!q.isEmpty()){
            ArrayList<String> vec=q.peek();
            q.remove();
            if(vec.size()>level){
                level++;
                for(String it: usedOnLevel){
                    st.remove(it);
                }
                usedOnLevel.clear();
            }

            String word=vec.get(vec.size()-1);
            if(word.equals(endWord)){
                    return vec.size();
                }

                for(int i=0; i<word.length();i++){
                    for(char c='a'; c<='z';c++){
                        char replacedCharArray[]= word.toCharArray();
                        replacedCharArray[i]=c;
                        String replacedWord=new String(replacedCharArray);
                        if(st.contains(replacedWord)==true){
                            vec.add(replacedWord);
                            ArrayList<String> temp= new ArrayList<>(vec);
                            q.add(temp);
                            usedOnLevel.add(replacedWord);
                            vec.remove(vec.size()-1);
                        

                    }
                }
            }
        }

            return 0;
        }
    }
