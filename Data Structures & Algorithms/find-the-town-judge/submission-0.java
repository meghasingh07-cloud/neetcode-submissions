class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustCount=new int[n+1];
        int[] trustedCount=new int[n+1];
        for(int i=0; i<trust.length;i++){
            int a=trust[i][0];
            int b= trust[i][1];

            trustCount[a]++;
            trustedCount[b]++;

        }
        for(int i=1; i<=n;i++){
            if(trustedCount[i]==n-1 && trustCount[i]==0){
            return i;
        }
        
        }
        return -1;

    }
}